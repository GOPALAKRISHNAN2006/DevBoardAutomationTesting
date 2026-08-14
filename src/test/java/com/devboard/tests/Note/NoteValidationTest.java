package com.devboard.tests.Note;

import com.devboard.base.BaseTest;
import com.devboard.config.ConfigReader;
import com.devboard.pages.DashboardPage;
import com.devboard.pages.LoginPage;
import com.devboard.pages.NotePage;
import com.devboard.utils.WaitUtils;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class NoteValidationTest extends BaseTest {

    @DataProvider(name = "noteValidationData")
    public Object[][] noteValidationData() {

        return new Object[][]{
                {"", "Content for validation test", "Testing", "empty title"},
                {"Validation Note", "", "Testing", "empty content"},
                {"", "", "Testing", "empty title and content"}
        };
    }

    @Test(dataProvider = "noteValidationData")
    public void noteValidationTest(
            String title,
            String content,
            String tags,
            String scenario
    ) {

        // Open login page
        driver.get(
                ConfigReader.getProperty("baseUrl") + "/login"
        );

        // Login
        LoginPage loginPage =
                new LoginPage(driver);

        loginPage.login(
                "gopalmuruga001@gmail.com",
                "1234567890"
        );

        // Wait for dashboard
        WaitUtils.waitForUrl(
                driver,
                "/dashboard"
        );

        // Create dashboard page
        DashboardPage dashboardPage =
                new DashboardPage(driver);

        // Navigate to notes
        dashboardPage.goToNotes();

        // Wait for notes page
        WaitUtils.waitForUrl(
                driver,
                "/notes"
        );

        // Create note page
        NotePage notePage =
                new NotePage(driver);

        // Open new note
        notePage.clickNewNote();

        // Enter title
        notePage.enterTitle(title);

        // Enter content
        notePage.enterContent(content);

        // Enter tags
        notePage.enterTags(tags);

        // Click save
        notePage.clickSave();

        // Wait for page response
        WaitUtils.waitForVisible(
                driver,
                By.tagName("body")
        );

        // Verify invalid note was not created
        if (title.isEmpty()) {

            Assert.assertFalse(
                    notePage.isNotePresent(title),
                    "Note with empty title was created."
            );

        } else if (content.isEmpty()) {

            Assert.assertFalse(
                    notePage.isNotePresent(title),
                    "Note with empty content was created."
            );

        } else {

            Assert.assertFalse(
                    notePage.isNotePresent(title),
                    "Note with empty title and content was created."
            );
        }

        System.out.println(
                "✅ " + scenario + " validation passed"
        );
    }
}