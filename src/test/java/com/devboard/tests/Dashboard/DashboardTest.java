package com.devboard.tests.Dashboard;

import com.devboard.base.BaseTest;
import com.devboard.config.ConfigReader;
import com.devboard.pages.DashboardPage;
import com.devboard.pages.LoginPage;
import com.devboard.utils.WaitUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DashboardTest extends BaseTest {

    @Test
    public void dashboardTest() {

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
        // VERIFY DASHBOARD
        // ==========================================

        Assert.assertTrue(
                dashboardPage.isDashboardLoaded(),
                "Dashboard was not loaded."
        );

        System.out.println(
                "✅ Dashboard Loaded Successfully"
        );

        // ==========================================
        // VERIFY MAIN STATISTICS
        // ==========================================

        Assert.assertTrue(
                dashboardPage.isTotalProjectsDisplayed(),
                "Total Projects statistic was not displayed."
        );

        Assert.assertTrue(
                dashboardPage.isTotalJobsDisplayed(),
                "Total Jobs statistic was not displayed."
        );

        Assert.assertTrue(
                dashboardPage.isTotalSkillsDisplayed(),
                "Total Skills statistic was not displayed."
        );

        Assert.assertTrue(
                dashboardPage.isOffersDisplayed(),
                "Offers statistic was not displayed."
        );

        System.out.println(
                "✅ Dashboard Main Statistics Displayed Successfully"
        );

        // ==========================================
        // VERIFY GITHUB STATISTICS
        // ==========================================

        if (dashboardPage.isGithubStatsAvailable()) {

            Assert.assertTrue(
                    dashboardPage.isGithubReposDisplayed(),
                    "GitHub Repositories statistic was not displayed."
            );

            Assert.assertTrue(
                    dashboardPage.isGithubStarsDisplayed(),
                    "GitHub Stars statistic was not displayed."
            );

            System.out.println(
                    "✅ GitHub Statistics Displayed Successfully"
            );

        } else {

            System.out.println(
                    "⚠️ GitHub Statistics Not Available - External API may not have responded."
            );
        }

        // ==========================================
        // VERIFY LEETCODE STATISTICS
        // ==========================================
        if (dashboardPage.isLeetcodeStatsAvailable()) {

            Assert.assertTrue(
                    dashboardPage.isLeetcodeSolvedDisplayed(),
                    "LeetCode Solved statistic was not displayed."
            );

            Assert.assertTrue(
                    dashboardPage.isLeetcodeRankDisplayed(),
                    "LeetCode Rank statistic was not displayed."
            );

            System.out.println(
                    "✅ LeetCode Statistics Displayed Successfully"
            );

        } else {

            System.out.println(
                    "⚠️ LeetCode Statistics Not Available - External API may not have responded."
            );
        }

        // ==========================================
        // VERIFY RECENT PROJECTS
        // ==========================================

        Assert.assertTrue(
                dashboardPage.isRecentProjectsDisplayed(),
                "Recent Projects section was not displayed."
        );

        System.out.println(
                "✅ Recent Projects Section Displayed Successfully"
        );

        // ==========================================
        // VERIFY RECENT JOBS
        // ==========================================

        Assert.assertTrue(
                dashboardPage.isRecentJobsDisplayed(),
                "Recent Applications section was not displayed."
        );

        System.out.println(
                "✅ Recent Applications Section Displayed Successfully"
        );

        // ==========================================
        // VERIFY RECENT GITHUB
        // ==========================================

        Assert.assertTrue(
                dashboardPage.isRecentGithubDisplayed(),
                "Recent GitHub section was not displayed."
        );

        System.out.println(
                "✅ Recent GitHub Section Displayed Successfully"
        );

        // ==========================================
        // FINAL RESULT
        // ==========================================

        System.out.println(
                "✅ Dashboard Test Passed"
        );
    }
}