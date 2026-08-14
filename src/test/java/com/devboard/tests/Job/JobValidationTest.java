package com.devboard.tests.Job;

import com.devboard.base.BaseTest;
import com.devboard.config.ConfigReader;
import com.devboard.pages.DashboardPage;
import com.devboard.pages.JobPage;
import com.devboard.pages.LoginPage;
import com.devboard.utils.WaitUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class JobValidationTest extends BaseTest {

    @Test
    public void emptyCompanyValidationTest() {
        driver.get(ConfigReader.getProperty("baseUrl") + "/login");

        LoginPage loginPage = new LoginPage(driver);

        loginPage.login("gopalmuruga001@gmail.com",
                "1234567890");

        WaitUtils.waitForUrl(driver, "/dashboard");

        DashboardPage dashboardPage = new DashboardPage(driver);

        dashboardPage.goToJobs();

        WaitUtils.waitForUrl(driver, "/jobs");

        JobPage jobPage = new JobPage(driver);

        jobPage.clickAddJob();

        jobPage.enterRole("Software Developer");

        jobPage.enterLocation("Chennai");

        jobPage.clickSave();

        Assert.assertTrue(jobPage.isJobFormDisplayed(),
                "Job form should remain open when company is empty");

        System.out.println("✅ Empty Company Validation Passed");

    }
    @Test
    public void emptyRoleValidationTest() {

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

        jobPage.clickAddJob();

        jobPage.enterCompany("Google");

        // Role intentionally empty

        jobPage.enterLocation("Bangalore");

        jobPage.clickSave();

        Assert.assertTrue(
                jobPage.isJobFormDisplayed(),
                "Job form should remain open when role is empty."
        );

        System.out.println(
                "✅ Empty Role Validation Passed"
        );
    }

    @Test
    public void emptyLocationValidationTest() {

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

        jobPage.clickAddJob();

        jobPage.enterCompany("Google");

        jobPage.enterRole("Software Engineer");

        // Location intentionally empty

        jobPage.clickSave();

        Assert.assertTrue(
                jobPage.isJobFormDisplayed(),
                "Job form should remain open when location is empty."
        );

        System.out.println(
                "✅ Empty Location Validation Passed"
        );
    }
}
