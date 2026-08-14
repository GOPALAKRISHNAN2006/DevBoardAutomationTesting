package com.devboard.tests.Note;

import com.devboard.base.BaseTest;
import com.devboard.config.ConfigReader;
import com.devboard.pages.DashboardPage;
import com.devboard.pages.LoginPage;
import com.devboard.pages.NotePage;
import com.devboard.utils.WaitUtils;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class NoteBoundaryTest extends BaseTest {

    @DataProvider(name = "noteBoundaryData")
    public Object[][] noteBoundaryData() {

        String longTitle =
                "This is a very long note title used to verify how the application handles large title input during Selenium automation testing";

        String longContent =
                "This is a very long note content used to verify that the DevBoard application can handle a large amount of text correctly during automated boundary testing. "
                        + "The purpose of this test is to ensure that the note creation functionality continues to work correctly when the user enters a large amount of content.";

        return new Object[][]{
                {longTitle, "Normal content", "Boundary", "very long title"},
                {"Boundary Content Note", longContent, "Boundary", "very long content"},
                {longTitle, longContent, "Boundary", "very long title and content"}
        };
    }

    @Test(dataProvider = "noteBoundaryData")
    public void noteBoundaryTest(
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

        // Create boundary test note
        notePage.createNote(
                title,
                content,
                tags
        );

        // Verify note was created
        Assert.assertTrue(
                notePage.isNotePresent(title),
                "Boundary note was not created for scenario: "
                        + scenario
        );

        System.out.println(
                "✅ " + scenario + " boundary test passed"
        );

        // Delete test note
        notePage.clickDeleteNote(title);

        // Verify note was deleted
        Assert.assertTrue(
                notePage.waitUntilNoteDeleted(title),
                "Boundary test note was not deleted for scenario: "
                        + scenario
        );

        System.out.println(
                "✅ " + scenario + " cleanup passed"
        );
    }
}