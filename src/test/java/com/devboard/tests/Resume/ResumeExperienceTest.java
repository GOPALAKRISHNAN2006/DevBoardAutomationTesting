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

public class ResumeExperienceTest extends BaseTest {

    @Test
    public void resumeExperienceTest() {

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

        // Verify experience section
        Assert.assertTrue(
                resumePage.isExperienceSectionDisplayed(),
                "Experience section was not displayed."
        );

        System.out.println(
                "✅ Resume Experience Section Displayed Successfully"
        );

        // Open add experience
        resumePage.clickAddExperience();

        System.out.println(
                "✅ Add Experience Form Opened Successfully"
        );

        // Test data
        String role =
                "Software Developer";

        String company =
                "DevBoard Technologies";

        String duration =
                "Jan 2026 - Present";

        String description =
                "Developed full stack web applications using Java, React, Node.js and MongoDB.";

        // Enter role
        resumePage.enterExperienceRole(
                role
        );

        // Enter company
        resumePage.enterExperienceCompany(
                company
        );

        // Enter duration
        resumePage.enterExperienceDuration(
                duration
        );

        // Enter description
        resumePage.enterExperienceDescription(
                description
        );

        System.out.println(
                "✅ Experience Details Entered Successfully"
        );

        // Save experience
        resumePage.clickSaveExperience();

        System.out.println(
                "✅ Experience Saved Successfully"
        );

        // Create explicit wait
        WebDriverWait wait =
                new WebDriverWait(
                        driver,
                        Duration.ofSeconds(10)
                );

        // Create locator for experience role
        By experienceRole =
                By.xpath(
                        "//div[contains(@data-testid,'resume-experience-')]" +
                                "//h6[contains(@data-testid,'resume-experience-role-')]" +
                                "[normalize-space()='" + role + "']"
                );

        // Wait for saved experience
        wait.until(driver -> {

            try {

                return driver.findElements(
                        experienceRole
                ).size() > 0;

            } catch (Exception e) {

                return false;
            }
        });

        // Verify role
        Assert.assertTrue(
                driver.findElements(
                        experienceRole
                ).size() > 0,
                "Saved experience role was not displayed."
        );

        System.out.println(
                "✅ Experience Role Displayed Successfully"
        );

        // Create locator for company
        By experienceCompany =
                By.xpath(
                        "//div[contains(@data-testid,'resume-experience-')]" +
                                "//span[contains(@data-testid,'resume-experience-company-')]" +
                                "[normalize-space()='" + company + "']"
                );

        // Wait for company
        wait.until(driver -> {

            try {

                return driver.findElements(
                        experienceCompany
                ).size() > 0;

            } catch (Exception e) {

                return false;
            }
        });

        // Verify company
        Assert.assertTrue(
                driver.findElements(
                        experienceCompany
                ).size() > 0,
                "Saved experience company was not displayed."
        );

        System.out.println(
                "✅ Experience Company Displayed Successfully"
        );

        // Refresh page
        driver.navigate().refresh();

        // Wait for resume page
        WaitUtils.waitForUrl(
                driver,
                "/resume"
        );

        // Wait for persisted experience
        wait.until(driver -> {

            try {

                return driver.findElements(
                        experienceRole
                ).size() > 0;

            } catch (Exception e) {

                return false;
            }
        });

        // Verify persisted role
        Assert.assertTrue(
                driver.findElements(
                        experienceRole
                ).size() > 0,
                "Experience role was not persisted after refresh."
        );

        // Verify persisted company
        Assert.assertTrue(
                driver.findElements(
                        experienceCompany
                ).size() > 0,
                "Experience company was not persisted after refresh."
        );

        System.out.println(
                "✅ Resume Experience Data Persisted Successfully"
        );

        // Final result
        System.out.println(
                "✅ Resume Experience Test Passed"
        );
    }
}