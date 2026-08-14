package com.devboard.tests.Resume;

import com.devboard.base.BaseTest;
import com.devboard.config.ConfigReader;
import com.devboard.pages.DashboardPage;
import com.devboard.pages.LoginPage;
import com.devboard.pages.ResumePage;
import com.devboard.utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class ResumeCertificationTest extends BaseTest {

    @Test
    public void resumeCertificationTest() {

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

        // Verify certification section
        Assert.assertTrue(
                resumePage.isCertificationSectionDisplayed(),
                "Certification section was not displayed."
        );

        System.out.println(
                "✅ Resume Certification Section Displayed Successfully"
        );

        // Open add certification
        resumePage.clickAddCertification();

        System.out.println(
                "✅ Add Certification Form Opened Successfully"
        );

        // Test data
        String title =
                "Java Programming Certification";

        String issuer =
                "Oracle";

        String year =
                "2026";

        // Enter certification title
        resumePage.enterCertificationTitle(
                title
        );

        // Enter certification issuer
        resumePage.enterCertificationIssuer(
                issuer
        );

        // Enter certification year
        resumePage.enterCertificationYear(
                year
        );

        System.out.println(
                "✅ Certification Details Entered Successfully"
        );

        // Save certification
        resumePage.clickSaveCertification();

        System.out.println(
                "✅ Certification Saved Successfully"
        );

        // Create explicit wait
        WebDriverWait wait =
                new WebDriverWait(
                        driver,
                        Duration.ofSeconds(10)
                );

        // Create locator for certification title
        By certificationTitle =
                By.xpath(
                        "//div[contains(@data-testid,'resume-certification-')]" +
                                "//h6[contains(@data-testid,'resume-certification-title-')]" +
                                "[normalize-space()='" + title + "']"
                );

        // Wait for saved certification
        wait.until(driver -> {

            try {

                return driver.findElements(
                        certificationTitle
                ).size() > 0;

            } catch (Exception e) {

                return false;
            }
        });

        // Verify certification title
        Assert.assertTrue(
                driver.findElements(
                        certificationTitle
                ).size() > 0,
                "Saved certification title was not displayed."
        );

        System.out.println(
                "✅ Certification Title Displayed Successfully"
        );

        // Create locator for certification issuer
        By certificationIssuer =
                By.xpath(
                        "//div[contains(@data-testid,'resume-certification-')]" +
                                "//span[contains(@data-testid,'resume-certification-issuer-')]" +
                                "[normalize-space()='" + issuer + "']"
                );

        // Wait for certification issuer
        wait.until(driver -> {

            try {

                return driver.findElements(
                        certificationIssuer
                ).size() > 0;

            } catch (Exception e) {

                return false;
            }
        });

        // Verify certification issuer
        Assert.assertTrue(
                driver.findElements(
                        certificationIssuer
                ).size() > 0,
                "Saved certification issuer was not displayed."
        );

        System.out.println(
                "✅ Certification Issuer Displayed Successfully"
        );

        // Refresh page
        driver.navigate().refresh();

        // Wait for resume page
        WaitUtils.waitForUrl(
                driver,
                "/resume"
        );

        // Wait for persisted certification
        wait.until(driver -> {

            try {

                return driver.findElements(
                        certificationTitle
                ).size() > 0;

            } catch (Exception e) {

                return false;
            }
        });

        // Verify persisted certification title
        Assert.assertTrue(
                driver.findElements(
                        certificationTitle
                ).size() > 0,
                "Certification title was not persisted after refresh."
        );

        // Verify persisted certification issuer
        Assert.assertTrue(
                driver.findElements(
                        certificationIssuer
                ).size() > 0,
                "Certification issuer was not persisted after refresh."
        );

        System.out.println(
                "✅ Resume Certification Data Persisted Successfully"
        );

        // Final result
        System.out.println(
                "✅ Resume Certification Test Passed"
        );
    }
}