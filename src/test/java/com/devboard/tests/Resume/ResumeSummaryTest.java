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

public class ResumeSummaryTest extends BaseTest {

    @Test
    public void resumeSummaryTest() {

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

        // Open summary editor
        resumePage.clickEditSummary();

        System.out.println(
                "✅ Resume Summary Editor Opened Successfully"
        );

        // Test data
        String headline =
                "Full Stack Java Developer";

        String summary =
                "B.Tech Information Technology student with experience building full stack web applications using Java, React, Node.js and MongoDB.";

        String skills =
                "Java, Selenium, React, Node.js, MongoDB";

        // Enter headline
        resumePage.enterHeadline(
                headline
        );

        // Enter summary
        resumePage.enterSummary(
                summary
        );

        // Enter skills
        resumePage.enterSkills(
                skills
        );

        System.out.println(
                "✅ Resume Summary Details Entered Successfully"
        );

        // Save summary
        resumePage.clickSaveSummary();

        System.out.println(
                "✅ Resume Summary Saved Successfully"
        );

        // Create explicit wait
        WebDriverWait wait =
                new WebDriverWait(
                        driver,
                        Duration.ofSeconds(10)
                );

        // Wait for updated headline
        wait.until(driver -> {

            try {

                String actualHeadline =
                        driver.findElement(
                                By.cssSelector(
                                        "[data-testid='resume-headline']"
                                )
                        ).getText();

                return actualHeadline.contains(
                        headline
                );

            } catch (Exception e) {

                return false;
            }
        });

        System.out.println(
                "✅ Updated Headline Displayed Successfully"
        );

        // Wait for updated summary
        wait.until(driver -> {

            try {

                String actualSummary =
                        driver.findElement(
                                By.cssSelector(
                                        "[data-testid='resume-summary-text']"
                                )
                        ).getText();

                return actualSummary.contains(
                        summary
                );

            } catch (Exception e) {

                return false;
            }
        });

        System.out.println(
                "✅ Updated Summary Displayed Successfully"
        );

        // Wait for updated skills
        wait.until(driver -> {

            try {

                String actualSkills =
                        driver.findElement(
                                By.cssSelector(
                                        "[data-testid='resume-skills-list']"
                                )
                        ).getText();

                return actualSkills.contains(
                        "Java"
                );

            } catch (Exception e) {

                return false;
            }
        });

        System.out.println(
                "✅ Updated Skills Displayed Successfully"
        );

        // Verify updated headline
        String actualHeadline =
                driver.findElement(
                        By.cssSelector(
                                "[data-testid='resume-headline']"
                        )
                ).getText();

        Assert.assertTrue(
                actualHeadline.contains(headline),
                "Updated headline was not displayed."
        );

        // Verify updated summary
        String actualSummary =
                driver.findElement(
                        By.cssSelector(
                                "[data-testid='resume-summary-text']"
                        )
                ).getText();

        Assert.assertTrue(
                actualSummary.contains(summary),
                "Updated summary was not displayed."
        );

        // Verify updated skills
        String actualSkills =
                driver.findElement(
                        By.cssSelector(
                                "[data-testid='resume-skills-list']"
                        )
                ).getText();

        Assert.assertTrue(
                actualSkills.contains("Java"),
                "Updated skills were not displayed."
        );

        System.out.println(
                "✅ Resume Summary Updated Successfully"
        );

        // Refresh page
        driver.navigate().refresh();

        // Wait for resume page
        WaitUtils.waitForUrl(
                driver,
                "/resume"
        );

        // Wait for persisted headline
        wait.until(driver -> {

            try {

                String savedHeadline =
                        driver.findElement(
                                By.cssSelector(
                                        "[data-testid='resume-headline']"
                                )
                        ).getText();

                return savedHeadline.contains(
                        headline
                );

            } catch (Exception e) {

                return false;
            }
        });

        // Verify persisted headline
        String savedHeadline =
                driver.findElement(
                        By.cssSelector(
                                "[data-testid='resume-headline']"
                        )
                ).getText();

        Assert.assertTrue(
                savedHeadline.contains(headline),
                "Headline was not persisted after refresh."
        );

        // Wait for persisted summary
        wait.until(driver -> {

            try {

                String savedSummary =
                        driver.findElement(
                                By.cssSelector(
                                        "[data-testid='resume-summary-text']"
                                )
                        ).getText();

                return savedSummary.contains(
                        summary
                );

            } catch (Exception e) {

                return false;
            }
        });

        // Verify persisted summary
        String savedSummary =
                driver.findElement(
                        By.cssSelector(
                                "[data-testid='resume-summary-text']"
                        )
                ).getText();

        Assert.assertTrue(
                savedSummary.contains(summary),
                "Summary was not persisted after refresh."
        );

        // Wait for persisted skills
        wait.until(driver -> {

            try {

                String savedSkills =
                        driver.findElement(
                                By.cssSelector(
                                        "[data-testid='resume-skills-list']"
                                )
                        ).getText();

                return savedSkills.contains(
                        "Java"
                );

            } catch (Exception e) {

                return false;
            }
        });

        // Verify persisted skills
        String savedSkills =
                driver.findElement(
                        By.cssSelector(
                                "[data-testid='resume-skills-list']"
                        )
                ).getText();

        Assert.assertTrue(
                savedSkills.contains("Java"),
                "Skills were not persisted after refresh."
        );

        System.out.println(
                "✅ Resume Summary Data Persisted Successfully"
        );

        // Final result
        System.out.println(
                "✅ Resume Summary Test Passed"
        );
    }
}