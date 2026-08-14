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

public class ResumeEducationTest extends BaseTest {

    @Test
    public void resumeEducationTest() {

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

        // Verify education section
        Assert.assertTrue(
                resumePage.isEducationSectionDisplayed(),
                "Education section was not displayed."
        );

        System.out.println(
                "✅ Resume Education Section Displayed Successfully"
        );

        // Open add education
        resumePage.clickAddEducation();

        System.out.println(
                "✅ Add Education Form Opened Successfully"
        );

        // Test data
        String degree =
                "B.Tech Information Technology";

        String institute =
                "Sri Shakthi Institute of Engineering and Technology";

        String year =
                "2027";

        String cgpa =
                "8.17";

        // Enter degree
        resumePage.enterEducationDegree(
                degree
        );

        // Enter institution
        resumePage.enterEducationInstitute(
                institute
        );

        // Enter graduation year
        resumePage.enterEducationYear(
                year
        );

        // Enter CGPA
        resumePage.enterEducationCgpa(
                cgpa
        );

        System.out.println(
                "✅ Education Details Entered Successfully"
        );

        // Save education
        resumePage.clickSaveEducation();

        System.out.println(
                "✅ Education Saved Successfully"
        );

        // Create explicit wait
        WebDriverWait wait =
                new WebDriverWait(
                        driver,
                        Duration.ofSeconds(10)
                );

        // Create locator for education degree
        By educationDegree =
                By.xpath(
                        "//div[contains(@data-testid,'resume-education-')]" +
                                "//h6[contains(@data-testid,'resume-education-degree-')]" +
                                "[normalize-space()='" + degree + "']"
                );

        // Wait for saved degree
        wait.until(driver -> {

            try {

                return driver.findElements(
                        educationDegree
                ).size() > 0;

            } catch (Exception e) {

                return false;
            }
        });

        // Verify degree
        Assert.assertTrue(
                driver.findElements(
                        educationDegree
                ).size() > 0,
                "Saved education degree was not displayed."
        );

        System.out.println(
                "✅ Education Degree Displayed Successfully"
        );

        // Create locator for institution
        By educationInstitute =
                By.xpath(
                        "//div[contains(@data-testid,'resume-education-')]" +
                                "//span[contains(@data-testid,'resume-education-institute-')]" +
                                "[normalize-space()='" + institute + "']"
                );

        // Wait for institution
        wait.until(driver -> {

            try {

                return driver.findElements(
                        educationInstitute
                ).size() > 0;

            } catch (Exception e) {

                return false;
            }
        });

        // Verify institution
        Assert.assertTrue(
                driver.findElements(
                        educationInstitute
                ).size() > 0,
                "Saved education institution was not displayed."
        );

        System.out.println(
                "✅ Education Institution Displayed Successfully"
        );

        // Refresh page
        driver.navigate().refresh();

        // Wait for resume page
        WaitUtils.waitForUrl(
                driver,
                "/resume"
        );

        // Wait for persisted education
        wait.until(driver -> {

            try {

                return driver.findElements(
                        educationDegree
                ).size() > 0;

            } catch (Exception e) {

                return false;
            }
        });

        // Verify persisted degree
        Assert.assertTrue(
                driver.findElements(
                        educationDegree
                ).size() > 0,
                "Education degree was not persisted after refresh."
        );

        // Verify persisted institution
        Assert.assertTrue(
                driver.findElements(
                        educationInstitute
                ).size() > 0,
                "Education institution was not persisted after refresh."
        );

        System.out.println(
                "✅ Resume Education Data Persisted Successfully"
        );

        // Final result
        System.out.println(
                "✅ Resume Education Test Passed"
        );
    }
}