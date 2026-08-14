package com.devboard.tests.Github;

import com.devboard.base.BaseTest;
import com.devboard.config.ConfigReader;
import com.devboard.pages.DashboardPage;
import com.devboard.pages.GithubPage;
import com.devboard.pages.LoginPage;
import com.devboard.utils.WaitUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GithubProfileTest extends BaseTest {

    @Test
    public void githubProfileTest() {

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

        // Navigate to GitHub
        DashboardPage dashboardPage =
                new DashboardPage(driver);

        dashboardPage.goToGithub();

        WaitUtils.waitForUrl(
                driver,
                "/github"
        );

        // GitHub Page
        GithubPage githubPage =
                new GithubPage(driver);

        // Verify GitHub page
        Assert.assertTrue(
                githubPage.isGithubPageLoaded(),
                "GitHub page was not loaded."
        );

        System.out.println(
                "✅ GitHub Page Loaded Successfully"
        );

        // Verify username
        Assert.assertTrue(
                githubPage.isUsernameDisplayed(),
                "GitHub username was not displayed."
        );

        System.out.println(
                "✅ GitHub Username Displayed Successfully"
        );

        // Verify repositories section
        Assert.assertTrue(
                githubPage.isRepositoriesSectionDisplayed(),
                "Repositories section was not displayed."
        );

        System.out.println(
                "✅ GitHub Repositories Section Displayed Successfully"
        );

        System.out.println(
                "✅ GitHub Profile Test Passed"
        );
    }
}