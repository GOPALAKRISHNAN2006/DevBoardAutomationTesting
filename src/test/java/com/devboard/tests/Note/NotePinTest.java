package com.devboard.tests.Note;

import com.devboard.base.BaseTest;
import com.devboard.config.ConfigReader;
import com.devboard.pages.DashboardPage;
import com.devboard.pages.LoginPage;
import com.devboard.pages.NotePage;
import com.devboard.utils.WaitUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NotePinTest extends BaseTest {

    @Test
    public void pinUnpinNoteTest() {

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

        String title = "Selenium Automation Notes";

        // Verify note exists
        Assert.assertTrue(
                notePage.isNotePresent(title),
                "Note does not exist."
        );

        // Make sure test always starts unpinned
        notePage.ensureUnpinned(title);

        // =========================
        // PIN
        // =========================

        notePage.clickPinNote(title);

        Assert.assertTrue(
                notePage.waitUntilPinned(title),
                "Note was not pinned."
        );

        System.out.println(
                "✅ Note Pinned Successfully"
        );

        // =========================
        // UNPIN
        // =========================

        notePage.clickPinNote(title);

        Assert.assertTrue(
                notePage.waitUntilUnpinned(title),
                "Note was not unpinned."
        );

        System.out.println(
                "✅ Note Unpinned Successfully"
        );

        System.out.println(
                "✅ Note Pin/Unpin Passed"
        );
    }
}