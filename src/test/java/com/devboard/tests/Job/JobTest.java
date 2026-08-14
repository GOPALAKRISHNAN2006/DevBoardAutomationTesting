package com.devboard.tests.Job;

import com.devboard.base.BaseTest;
import com.devboard.config.ConfigReader;
import com.devboard.pages.DashboardPage;
import com.devboard.pages.JobPage;
import com.devboard.pages.LoginPage;
import com.devboard.utils.WaitUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class JobTest extends BaseTest {

    @Test
    public void addJobTest() {

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

        // Wait for Dashboard
        WaitUtils.waitForUrl(
                driver,
                "/dashboard"
        );

        // Navigate to Jobs
        DashboardPage dashboardPage =
                new DashboardPage(driver);

        dashboardPage.goToJobs();

        // Wait for Jobs page
        WaitUtils.waitForUrl(
                driver,
                "/jobs"
        );

        // Job Page
        JobPage jobPage =
                new JobPage(driver);

        // Add Job
        jobPage.addJob(
                "Amazon",
                "Software Engineer",
                "Bangalore",
                "Hybrid",
                "Applied",
                "Applied through company website"
        );

        // Verify
        Assert.assertTrue(
                jobPage.isJobPresent(
                        "Amazon",
                        "Software Engineer"
                ),
                "Job was not added successfully."
        );

        System.out.println(
                "✅ Job Created Successfully"
        );
    }
}