package com.devboard.tests.Project;


import com.devboard.base.BaseTest;
import com.devboard.config.ConfigReader;
import com.devboard.pages.DashboardPage;
import com.devboard.pages.LoginPage;
import com.devboard.pages.ProjectPage;
import com.devboard.utils.WaitUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProjectFilterTest extends BaseTest {

    @Test
    public void completedStatusFilterTest() {

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
        WaitUtils.waitForUrl(driver, "/dashboard");

        // Go to Projects
        DashboardPage dashboardPage =
                new DashboardPage(driver);

        dashboardPage.goToProjects();

        WaitUtils.waitForUrl(driver, "/projects");

        // Projects
        ProjectPage projectPage =
                new ProjectPage(driver);

        // Select Completed
        projectPage.filterByStatus("Completed");

        // Verify selected filter
        Assert.assertEquals(
                projectPage.getSelectedStatusFilter(),
                "Completed",
                "Completed status filter was not selected."
        );

        System.out.println(
                "✅ Completed status filter passed"
        );
    }

    @Test
    public void inProgressStatusFilterTest() {

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

        projectPage.filterByStatus("In Progress");

        Assert.assertEquals(
                projectPage.getSelectedStatusFilter(),
                "In Progress",
                "In Progress filter was not selected."
        );

        System.out.println(
                "✅ In Progress status filter passed"
        );
    }

    @Test
    public void plannedStatusFilterTest() {

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

        projectPage.filterByStatus("Planned");

        Assert.assertEquals(
                projectPage.getSelectedStatusFilter(),
                "Planned",
                "Planned filter was not selected."
        );

        System.out.println(
                "✅ Planned status filter passed"
        );
    }

}