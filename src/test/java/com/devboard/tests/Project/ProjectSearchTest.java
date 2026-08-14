package com.devboard.tests.Project;

import com.devboard.base.BaseTest;
import com.devboard.config.ConfigReader;
import com.devboard.pages.DashboardPage;
import com.devboard.pages.LoginPage;
import com.devboard.pages.ProjectPage;
import com.devboard.utils.WaitUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProjectSearchTest extends BaseTest {

    @Test
    public void searchExistingProject() {

        driver.get(ConfigReader.getProperty("baseUrl") + "/login");

        LoginPage loginPage = new LoginPage(driver);

        loginPage.login(
                "gopalmuruga001@gmail.com",
                "1234567890"
        );

        WaitUtils.waitForUrl(driver, "/dashboard");

        DashboardPage dashboardPage =
                new DashboardPage(driver);

        dashboardPage.goToProjects();

        ProjectPage projectPage =
                new ProjectPage(driver);

        System.out.print(driver.getCurrentUrl());
        projectPage.searchProject("DevBoard Updated");
        Assert.assertTrue(
                projectPage.isProjectPresent("DevBoard Updated")
        );

    }

    @Test
    public void searchNonExistingProjectTest() {

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

        String searchText = "ProjectThatDoesNotExist123";

        projectPage.searchProject(searchText);

        Assert.assertFalse(
                projectPage.isProjectPresent(searchText),
                "Non-existing project should not be displayed."
        );

        System.out.println(
                "✅ Non-existing project search validation passed"
        );
    }

}