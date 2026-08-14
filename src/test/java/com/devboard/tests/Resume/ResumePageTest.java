package com.devboard.tests.Resume;

import com.devboard.base.BaseTest;
import com.devboard.config.ConfigReader;
import com.devboard.pages.DashboardPage;
import com.devboard.pages.LoginPage;
import com.devboard.pages.ResumePage;
import com.devboard.utils.WaitUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ResumePageTest extends BaseTest {

    @Test
    public void resumePageTest() {

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

        // ==========================================
        // NAVIGATE TO RESUME
        // ==========================================

        dashboardPage.goToResume();

        WaitUtils.waitForUrl(
                driver,
                "/resume"
        );

        // ==========================================
        // RESUME PAGE
        // ==========================================

        ResumePage resumePage =
                new ResumePage(driver);

        Assert.assertTrue(
                resumePage.isResumePageLoaded(),
                "Resume page was not loaded."
        );

        System.out.println(
                "✅ Resume Page Loaded Successfully"
        );

        // ==========================================
        // VERIFY HEADER ACTIONS
        // ==========================================

        Assert.assertTrue(
                resumePage.isPreviewButtonDisplayed(),
                "Preview button was not displayed."
        );

        Assert.assertTrue(
                resumePage.isDownloadButtonDisplayed(),
                "Download button was not displayed."
        );

        System.out.println(
                "✅ Resume Header Actions Displayed Successfully"
        );

        // ==========================================
        // VERIFY READINESS
        // ==========================================

        Assert.assertTrue(
                resumePage.isReadinessSectionDisplayed(),
                "Resume readiness section was not displayed."
        );

        Assert.assertTrue(
                resumePage.isCompletionScoreDisplayed(),
                "Resume completion score was not displayed."
        );

        System.out.println(
                "✅ Resume Readiness Section Displayed Successfully"
        );

        // ==========================================
        // VERIFY SUMMARY
        // ==========================================

        Assert.assertTrue(
                resumePage.isSummarySectionDisplayed(),
                "Resume summary section was not displayed."
        );

        System.out.println(
                "✅ Resume Summary Section Displayed Successfully"
        );

        // ==========================================
        // VERIFY EXPERIENCE
        // ==========================================

        Assert.assertTrue(
                resumePage.isExperienceSectionDisplayed(),
                "Experience section was not displayed."
        );

        System.out.println(
                "✅ Resume Experience Section Displayed Successfully"
        );

        // ==========================================
        // VERIFY EDUCATION
        // ==========================================

        Assert.assertTrue(
                resumePage.isEducationSectionDisplayed(),
                "Education section was not displayed."
        );

        System.out.println(
                "✅ Resume Education Section Displayed Successfully"
        );

        // ==========================================
        // VERIFY CERTIFICATIONS
        // ==========================================

        Assert.assertTrue(
                resumePage.isCertificationSectionDisplayed(),
                "Certification section was not displayed."
        );

        System.out.println(
                "✅ Resume Certification Section Displayed Successfully"
        );

        // ==========================================
        // FINAL RESULT
        // ==========================================

        System.out.println(
                "✅ Resume Page Test Passed"
        );
    }
}