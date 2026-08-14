package com.devboard.tests.Github;

import com.devboard.base.BaseTest;
import com.devboard.config.ConfigReader;
import com.devboard.pages.DashboardPage;
import com.devboard.pages.GithubPage;
import com.devboard.pages.LoginPage;
import com.devboard.utils.WaitUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GithubRepositoryTest extends BaseTest {

    @Test
    public void githubRepositoryTest() {

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

        // Verify repositories
        Assert.assertTrue(
                githubPage.areRepositoriesDisplayed(),
                "No GitHub repositories were displayed."
        );

        System.out.println(
                "✅ GitHub Repositories Displayed Successfully"
        );

        System.out.println(
                "✅ GitHub Repository Test Passed"
        );
    }
}