package com.devboard.tests.Job;

import com.devboard.base.BaseTest;
import com.devboard.config.ConfigReader;
import com.devboard.pages.DashboardPage;
import com.devboard.pages.JobPage;
import com.devboard.pages.LoginPage;
import com.devboard.utils.WaitUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class JobPaginationTest extends BaseTest {

    @Test
    public void jobPaginationTest() {

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

        // Verify Page 1
        Assert.assertTrue(
                jobPage.isPaginationPageActive(1),
                "Page 1 should be active initially."
        );

        // Click Next
        jobPage.clickNextPage();

        // Verify Page 2
        Assert.assertTrue(
                jobPage.isPaginationPageActive(2),
                "Page 2 should be active after clicking Next."
        );

        // Click Previous
        jobPage.clickPreviousPage();

        // Verify Page 1 again
        Assert.assertTrue(
                jobPage.isPaginationPageActive(1),
                "Page 1 should be active after clicking Previous."
        );

        System.out.println(
                "✅ Job Pagination Test Passed"
        );
    }
}