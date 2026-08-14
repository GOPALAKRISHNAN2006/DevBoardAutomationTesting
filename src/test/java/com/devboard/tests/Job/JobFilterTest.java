package com.devboard.tests.Job;

import com.devboard.base.BaseTest;
import com.devboard.config.ConfigReader;
import com.devboard.pages.DashboardPage;
import com.devboard.pages.JobPage;
import com.devboard.pages.LoginPage;
import com.devboard.utils.WaitUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class JobFilterTest extends BaseTest {

    @Test
    public void filterJobsByStatusTest() {

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

        WaitUtils.waitForUrl(
                driver,
                "/jobs"
        );

        // Job Page
        JobPage jobPage =
                new JobPage(driver);

        // Filter
        jobPage.filterByStatus("Offer");

        // Verify
        Assert.assertTrue(
                jobPage.areAllJobsStatus("Offer"),
                "Jobs with other statuses are displayed."
        );

        System.out.println(
                "✅ Job Status Filter Passed"
        );
    }
}