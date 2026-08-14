package com.devboard.tests.Leetcode;

import com.devboard.base.BaseTest;
import com.devboard.config.ConfigReader;
import com.devboard.pages.DashboardPage;
import com.devboard.pages.LeetcodePage;
import com.devboard.pages.LoginPage;
import com.devboard.utils.WaitUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LeetcodeProfileTest extends BaseTest {

    @Test
    public void leetcodeProfileTest() {

        // LOGIN
        driver.get(
                ConfigReader.getProperty("baseUrl") + "/login"
        );

        LoginPage loginPage =
                new LoginPage(driver);

        loginPage.login(
                "gopalmuruga001@gmail.com",
                "1234567890"
        );

        // DASHBOARD
        WaitUtils.waitForUrl(
                driver,
                "/dashboard"
        );

        DashboardPage dashboardPage =
                new DashboardPage(driver);

        // Navigate to LeetCode
        dashboardPage.goToLeetcode();

        WaitUtils.waitForUrl(
                driver,
                "/leetcode"
        );

        // LEETCODE PAGE
        LeetcodePage leetcodePage =
                new LeetcodePage(driver);

        // Verify page loaded
        Assert.assertTrue(
                leetcodePage.isLeetcodePageLoaded(),
                "LeetCode page was not loaded."
        );

        System.out.println(
                "✅ LeetCode Page Loaded Successfully"
        );

        // VERIFY PROFILE
        Assert.assertTrue(
                leetcodePage.isProfileDisplayed(),
                "LeetCode profile was not displayed."
        );

        System.out.println(
                "✅ LeetCode Profile Displayed Successfully"
        );


        // VERIFY USERNAME
        Assert.assertTrue(
                leetcodePage.isUsernameDisplayed(),
                "LeetCode username was not displayed."
        );

        System.out.println(
                "✅ LeetCode Username Displayed Successfully"
        );


        // VERIFY TOTAL SOLVED

        Assert.assertTrue(
                leetcodePage.isTotalSolvedDisplayed(),
                "Total solved count was not displayed."
        );

        System.out.println(
                "✅ LeetCode Total Solved Displayed Successfully"
        );


        // VERIFY DIFFICULTY STATS

        Assert.assertTrue(
                leetcodePage.areDifficultyStatsDisplayed(),
                "LeetCode difficulty statistics were not displayed."
        );

        System.out.println(
                "✅ LeetCode Easy/Medium/Hard Stats Displayed Successfully"
        );

        //Verify PROFILE BUTTON
        // ==========================================

        Assert.assertTrue(
                leetcodePage.isOpenProfileButtonDisplayed(),
                "Open LeetCode button was not displayed."
        );

        System.out.println(
                "✅ Open LeetCode Button Displayed Successfully"
        );


        // FINAL RESULT

        System.out.println(
                "✅ LeetCode Profile Test Passed"
        );
    }
}