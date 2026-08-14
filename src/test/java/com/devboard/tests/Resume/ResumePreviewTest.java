package com.devboard.tests.Resume;

import com.devboard.base.BaseTest;
import com.devboard.config.ConfigReader;
import com.devboard.pages.DashboardPage;
import com.devboard.pages.LoginPage;
import com.devboard.pages.ResumePage;
import com.devboard.utils.WaitUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ResumePreviewTest extends BaseTest {

    @Test
    public void resumePreviewTest() {

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

        // Navigate to resume
        dashboardPage.goToResume();

        // Wait for resume page
        WaitUtils.waitForUrl(
                driver,
                "/resume"
        );

        // Create resume page
        ResumePage resumePage =
                new ResumePage(driver);

        // Verify resume page
        Assert.assertTrue(
                resumePage.isResumePageLoaded(),
                "Resume page was not loaded."
        );

        System.out.println(
                "✅ Resume Page Loaded Successfully"
        );

        // Verify preview button
        Assert.assertTrue(
                resumePage.isPreviewButtonDisplayed(),
                "Preview button was not displayed."
        );

        System.out.println(
                "✅ Resume Preview Button Displayed Successfully"
        );

        // Open preview
        resumePage.clickPreview();

        // Verify preview title
        Assert.assertTrue(
                resumePage.isPreviewTitleDisplayed(),
                "Resume preview was not opened."
        );

        System.out.println(
                "✅ Resume Preview Opened Successfully"
        );

        // Verify preview content
        Assert.assertTrue(
                resumePage.isPreviewDisplayed(),
                "Resume preview content was not displayed."
        );

        System.out.println(
                "✅ Resume Preview Content Displayed Successfully"
        );

        // Verify preview download button
        resumePage.clickPreviewDownload();

        System.out.println(
                "✅ Resume Print / Save PDF Action Triggered Successfully"
        );

        // Final result
        System.out.println(
                "✅ Resume Preview Test Passed"
        );
    }
}