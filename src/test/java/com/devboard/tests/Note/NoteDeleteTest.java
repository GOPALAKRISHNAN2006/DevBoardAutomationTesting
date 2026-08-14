package com.devboard.tests.Note;

import com.devboard.base.BaseTest;
import com.devboard.config.ConfigReader;
import com.devboard.pages.DashboardPage;
import com.devboard.pages.LoginPage;
import com.devboard.pages.NotePage;
import com.devboard.utils.WaitUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NoteDeleteTest extends BaseTest {

    @Test
    public void deleteNoteTest() {

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

        NotePage notePage =
                new NotePage(driver);

        // Create a note specifically for deletion
        String title =
                "Delete Test Note";

        String content =
                "This note is created for delete testing.";

        String tags =
                "Delete,Selenium";

        notePage.createNote(
                title,
                content,
                tags
        );

        // Verify note exists
        Assert.assertTrue(
                notePage.isNotePresent(title),
                "Note was not created before deletion."
        );

        // Delete note
        notePage.clickDeleteNote(title);

        // Wait until note disappears
        Assert.assertTrue(
                notePage.waitUntilNoteDeleted(title),
                "Note was not deleted successfully."
        );

        System.out.println(
                "✅ Note Deleted Successfully"
        );
    }
}