package com.devboard.tests.Job;

import com.devboard.base.BaseTest;
import com.devboard.config.ConfigReader;
import com.devboard.pages.DashboardPage;
import com.devboard.pages.JobPage;
import com.devboard.pages.LoginPage;
import com.devboard.utils.WaitUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class JobSearchTest extends BaseTest {

    @Test
    public void searchExistingJobTest() {

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

        // Navigate to Jobs
        DashboardPage dashboardPage =
                new DashboardPage(driver);

        dashboardPage.goToJobs();

        // Jobs page
        WaitUtils.waitForUrl(
                driver,
                "/jobs"
        );

        JobPage jobPage =
                new JobPage(driver);

        // Search
        jobPage.searchJob("Amazon");

        // Verify
        Assert.assertTrue(
                jobPage.isJobPresent(
                        "Amazon",
                        "Software Engineer"
                ),
                "Google job was not found."
        );

        System.out.println(
                "✅ Existing job search passed"
        );
    }

    @Test
    public void searchNonExistingJobTest() {

        driver.get(
                ConfigReader.getProperty("baseUrl") + "/login"
        );

        LoginPage loginPage =
                new LoginPage(driver);

        loginPage.login(
                "gopalmuruga001@gmail.com",
                "1234567890"
        );

        WaitUtils.waitForUrl(
                driver,
                "/dashboard"
        );

        DashboardPage dashboardPage =
                new DashboardPage(driver);

        dashboardPage.goToJobs();

        WaitUtils.waitForUrl(
                driver,
                "/jobs"
        );

        JobPage jobPage =
                new JobPage(driver);

        String searchText =
                "CompanyThatDoesNotExist123";

        jobPage.searchJob(searchText);

        Assert.assertFalse(
                jobPage.isJobPresent(
                        searchText,
                        "Software Engineer"
                ),
                "Non-existing job should not be displayed."
        );

        System.out.println(
                "✅ Non-existing job search passed"
        );
    }
}