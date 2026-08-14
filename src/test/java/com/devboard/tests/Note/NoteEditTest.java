package com.devboard.tests.Note;

import com.devboard.base.BaseTest;
import com.devboard.config.ConfigReader;
import com.devboard.pages.DashboardPage;
import com.devboard.pages.LoginPage;
import com.devboard.pages.NotePage;
import com.devboard.utils.WaitUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NoteEditTest extends BaseTest {

    @Test
    public void editNoteTest() {

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

        // Wait for Dashboard
        WaitUtils.waitForUrl(
                driver,
                "/dashboard"
        );

        // Navigate to Notes
        DashboardPage dashboardPage =
                new DashboardPage(driver);

        dashboardPage.goToNotes();

        // Wait for Notes
        WaitUtils.waitForUrl(
                driver,
                "/notes"
        );

        // Note Page
        NotePage notePage =
                new NotePage(driver);

        String oldTitle =
                "Testing Edit";

        String content =
                "This note is created for edit testing.";

        String tags =
                "Automation";

        String newTitle =
                "Selenium Automation Updated";

        // Create Note
        notePage.createNote(
                oldTitle,
                content,
                tags
        );

        // Verify Note Created
        Assert.assertTrue(
                notePage.isNotePresent(oldTitle),
                "Test note was not created successfully."
        );

        System.out.println(
                "✅ Test Note Created Successfully"
        );

        // Edit Note
        notePage.editNote(
                oldTitle,
                newTitle
        );

        // Verify Updated Note
        Assert.assertTrue(
                notePage.isNotePresent(newTitle),
                "Note was not updated successfully."
        );

        System.out.println(
                "✅ Note Updated Successfully"
        );
    }
}