package com.devboard.tests.Job;

import com.devboard.base.BaseTest;
import com.devboard.config.ConfigReader;
import com.devboard.pages.DashboardPage;
import com.devboard.pages.JobPage;
import com.devboard.pages.LoginPage;
import com.devboard.utils.WaitUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class JobEditTest extends BaseTest {

    @Test
    public void editJobTest() {

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

        String company = "Amazon";

        String oldRole = "Software Engineer";

        String newRole = "Senior Software Engineer";

        jobPage.editJob(
                company,
                oldRole,
                newRole
        );

        Assert.assertTrue(
                jobPage.isJobPresent(
                        company,
                        newRole
                ),
                "Job was not updated successfully."
        );

        System.out.println(
                "✅ Job Updated Successfully"
        );
    }
}