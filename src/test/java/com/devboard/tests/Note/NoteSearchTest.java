package com.devboard.tests.Note;

import com.devboard.base.BaseTest;
import com.devboard.config.ConfigReader;
import com.devboard.pages.DashboardPage;
import com.devboard.pages.LoginPage;
import com.devboard.pages.NotePage;
import com.devboard.utils.WaitUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NoteSearchTest extends BaseTest {

    @Test
    public void searchExistingNoteTest() {

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

        // Search
        String title =
                "Selenium Automation Notes";

        notePage.searchNote(title);

        // Verify
        Assert.assertTrue(
                notePage.isNotePresent(title),
                "Note was not found after searching."
        );

        System.out.println(
                "✅ Existing Note Search Passed"
        );
    }
    @Test
    public void searchNonExistingNoteTest() {

        driver.get(
                ConfigReader.getProperty("baseUrl") + "/login"
        );

        LoginPage loginPage =
                new LoginPage(driver);

        loginPage.login(
                "gopalmuruga001@gmail.com",
                "1234567890"
        );

        WaitUtils.waitForUrl(
                driver,
                "/dashboard"
        );

        DashboardPage dashboardPage =
                new DashboardPage(driver);

        dashboardPage.goToNotes();

        WaitUtils.waitForUrl(
                driver,
                "/notes"
        );

        NotePage notePage =
                new NotePage(driver);

        String searchText =
                "NoteThatDoesNotExist123";

        notePage.searchNote(searchText);

        Assert.assertFalse(
                notePage.isNotePresent(searchText),
                "Non-existing note should not be displayed."
        );

        System.out.println(
                "✅ Non-existing Note Search Passed"
        );
    }
}