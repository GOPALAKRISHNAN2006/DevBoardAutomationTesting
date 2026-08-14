package com.devboard.tests.Project;

import com.devboard.base.BaseTest;
import com.devboard.config.ConfigReader;
import com.devboard.pages.DashboardPage;
import com.devboard.pages.LoginPage;
import com.devboard.pages.ProjectPage;
import com.devboard.utils.WaitUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProjectValidationTest extends BaseTest {

    @Test
    public void emptyTitleValidationTest() {

        driver.get(
                ConfigReader.getProperty("baseUrl") + "/login"
        );

        LoginPage loginPage = new LoginPage(driver);

        loginPage.login(
                "gopalmuruga001@gmail.com",
                "1234567890"
        );

        WaitUtils.waitForUrl(driver, "/dashboard");

        DashboardPage dashboardPage =
                new DashboardPage(driver);

        dashboardPage.goToProjects();

        WaitUtils.waitForUrl(driver, "/projects");

        ProjectPage projectPage =
                new ProjectPage(driver);

        projectPage.addProjectWithoutTitle(
                "Testing project validation",
                "React,Selenium",
                "https://github.com/demo",
                "https://demo.com",
                "Completed"
        );

        Assert.assertTrue(
                projectPage.isTitleInvalid(),
                "Title should be required."
        );

        System.out.println(
                "✅ Empty title validation passed"
        );
    }

    @Test
    public void emptyDescriptionValidationTest() {

        driver.get(
                ConfigReader.getProperty("baseUrl") + "/login"
        );

        LoginPage loginPage = new LoginPage(driver);

        loginPage.login(
                "gopalmuruga001@gmail.com",
                "1234567890"
        );

        WaitUtils.waitForUrl(driver, "/dashboard");

        DashboardPage dashboardPage =
                new DashboardPage(driver);

        dashboardPage.goToProjects();

        WaitUtils.waitForUrl(driver, "/projects");

        ProjectPage projectPage =
                new ProjectPage(driver);

        projectPage.addProjectWithoutDescription(
                "Validation Test Project",
                "React,Selenium",
                "https://github.com/demo",
                "https://demo.com",
                "Completed"
        );

        Assert.assertTrue(
                projectPage.isDescriptionInvalid(),
                "Description should be required."
        );

        System.out.println(
                "✅ Empty description validation passed"
        );
    }
}