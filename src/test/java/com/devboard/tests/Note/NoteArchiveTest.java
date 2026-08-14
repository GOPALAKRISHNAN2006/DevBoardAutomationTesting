package com.devboard.tests.Note;

import com.devboard.base.BaseTest;
import com.devboard.config.ConfigReader;
import com.devboard.pages.DashboardPage;
import com.devboard.pages.LoginPage;
import com.devboard.pages.NotePage;
import com.devboard.utils.WaitUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NoteArchiveTest extends BaseTest {

    @Test
    public void archiveUnarchiveNoteTest() {

        // ==========================================
        // LOGIN
        // ==========================================

        driver.get(
                ConfigReader.getProperty("baseUrl") + "/login"
        );

        LoginPage loginPage =
                new LoginPage(driver);

        loginPage.login(
                "gopalmuruga001@gmail.com",
                "1234567890"
        );

        // ==========================================
        // DASHBOARD
        // ==========================================

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

        String title = "Testing";

        // ==========================================
        // VERIFY NOTE EXISTS IN ACTIVE NOTES
        // ==========================================

        Assert.assertTrue(
                notePage.isNotePresent(title),
                "Note does not exist in Active Notes."
        );

        System.out.println(
                "✅ Note Found in Active Notes"
        );

        // ==========================================
        // ARCHIVE
        // ==========================================

        notePage.clickArchiveNote(title);

        Assert.assertTrue(
                notePage.waitUntilNoteDisappears(title),
                "Note was not archived successfully."
        );

        System.out.println(
                "✅ Note Archived Successfully"
        );

        // ==========================================
        // OPEN ARCHIVED FILTER
        // ==========================================

        notePage.clickArchivedFilter();

        // ==========================================
        // VERIFY NOTE EXISTS IN ARCHIVED
        // ==========================================

        Assert.assertTrue(
                notePage.isNotePresent(title),
                "Archived note was not found."
        );

        Assert.assertTrue(
                notePage.waitUntilArchived(title),
                "Note is not in archived state."
        );

        System.out.println(
                "✅ Archived Note Found Successfully"
        );

        // ==========================================
        // UNARCHIVE
        // ==========================================

        notePage.clickArchiveNote(title);

        Assert.assertTrue(
                notePage.waitUntilNoteDisappears(title),
                "Note was not unarchived successfully."
        );

        System.out.println(
                "✅ Note Unarchived Successfully"
        );

        // ==========================================
        // OPEN ACTIVE FILTER
        // ==========================================

        notePage.clickActiveFilter();

        // ==========================================
        // VERIFY NOTE RETURNS TO ACTIVE
        // ==========================================

        Assert.assertTrue(
                notePage.isNotePresent(title),
                "Unarchived note was not found in Active Notes."
        );

        Assert.assertTrue(
                notePage.waitUntilUnarchived(title),
                "Note is not in active state."
        );

        System.out.println(
                "✅ Note Returned to Active Notes"
        );

        // ==========================================
        // FINAL RESULT
        // ==========================================

        System.out.println(
                "✅ Note Archive/Unarchive Passed"
        );
    }
}