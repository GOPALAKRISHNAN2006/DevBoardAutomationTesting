package com.devboard.tests.Note;

import com.devboard.base.BaseTest;
import com.devboard.config.ConfigReader;
import com.devboard.pages.DashboardPage;
import com.devboard.pages.LoginPage;
import com.devboard.pages.NotePage;
import com.devboard.utils.WaitUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NoteTest extends BaseTest {

    @Test
    public void createNoteTest() {

        // Open Login
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

        // Dashboard
        WaitUtils.waitForUrl(
                driver,
                "/dashboard"
        );

        // Navigate to Notes
        DashboardPage dashboardPage =
                new DashboardPage(driver);

        dashboardPage.goToNotes();

        WaitUtils.waitForUrl(
                driver,
                "/notes"
        );

        // Notes Page
        NotePage notePage =
                new NotePage(driver);

        // Create note
        String title =
                "Selenium Automation Notes";

        String content =
                "Learning Selenium WebDriver with Java and TestNG.";

        String tags =
                "Selenium,Java,TestNG";

        notePage.createNote(
                title,
                content,
                tags
        );

        // Verify
        Assert.assertTrue(
                notePage.isNotePresent(title),
                "Note was not created successfully."
        );

        System.out.println(
                "✅ Note Created Successfully"
        );
    }
}