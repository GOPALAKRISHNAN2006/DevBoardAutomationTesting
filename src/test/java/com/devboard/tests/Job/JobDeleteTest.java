package com.devboard.tests.Job;

import com.devboard.base.BaseTest;
import com.devboard.config.ConfigReader;
import com.devboard.pages.DashboardPage;
import com.devboard.pages.JobPage;
import com.devboard.pages.LoginPage;
import com.devboard.utils.WaitUtils;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class JobDeleteTest extends BaseTest {

    @Test
    public void deleteJobTest() {

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

        String company = "Amazon";
        String role = "Software Engineer";

        // Verify job exists before deletion
        Assert.assertTrue(
                jobPage.isJobPresent(company, role),
                "Job does not exist before deletion."
        );

        // Delete
        jobPage.clickDeleteJob(
                company,
                role
        );

        // Wait for list/API refresh
        WaitUtils.waitForVisible(
                driver,
                By.cssSelector(".card")
        );

        // Verify deleted
        Assert.assertFalse(
                jobPage.isJobPresent(company, role),
                "Job was not deleted successfully."
        );

        System.out.println(
                "✅ Job Deleted Successfully"
        );
    }
}