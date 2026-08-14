package com.devboard.tests.Job;

import com.devboard.base.BaseTest;
import com.devboard.config.ConfigReader;
import com.devboard.pages.DashboardPage;
import com.devboard.pages.JobPage;
import com.devboard.pages.LoginPage;
import com.devboard.utils.WaitUtils;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class JobValidationDataProviderTest extends BaseTest {

    @DataProvider(name = "jobValidationData")
    public Object[][] jobValidationData() {

        return new Object[][]{
                {"", "Software Developer", "Chennai", "empty company"},
                {"Google", "", "Bangalore", "empty role"},
                {"Google", "Software Engineer", "", "empty location"}
        };
    }

    @Test(dataProvider = "jobValidationData")
    public void jobValidationTest(
            String company,
            String role,
            String location,
            String scenario
    ) {

        // Open login page
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

        // Wait for dashboard
        WaitUtils.waitForUrl(
                driver,
                "/dashboard"
        );

        // Create dashboard page
        DashboardPage dashboardPage =
                new DashboardPage(driver);

        // Navigate to jobs
        dashboardPage.goToJobs();

        // Wait for jobs page
        WaitUtils.waitForUrl(
                driver,
                "/jobs"
        );

        // Create job page
        JobPage jobPage =
                new JobPage(driver);

        // Open job form
        jobPage.clickAddJob();

        // Enter company
        jobPage.enterCompany(company);

        // Enter role
        jobPage.enterRole(role);

        // Enter location
        jobPage.enterLocation(location);

        // Save job
        jobPage.clickSave();

        // Verify form remains open
        Assert.assertTrue(
                jobPage.isJobFormDisplayed(),
                "Job form should remain open for scenario: "
                        + scenario
        );

        System.out.println(
                "✅ " + scenario + " validation passed"
        );
    }
}