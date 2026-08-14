package com.devboard.tests.Project;

import com.devboard.base.BaseTest;
import com.devboard.config.ConfigReader;
import com.devboard.pages.DashboardPage;
import com.devboard.pages.LoginPage;
import com.devboard.pages.ProjectPage;
import com.devboard.utils.WaitUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProjectDeleteTest extends BaseTest {

    @Test
    public void deleteProjectTest() {

        // Open Login
        driver.get(
                ConfigReader.getProperty("baseUrl") + "/login"
        );

        // Login
        LoginPage loginPage = new LoginPage(driver);

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

        // Project Page
        ProjectPage projectPage =
                new ProjectPage(driver);

        String projectName = "DevBoard";

        // Verify project exists first
        Assert.assertTrue(
                projectPage.isProjectPresent(projectName),
                "Project does not exist before deletion."
        );

        // Delete
        projectPage.deleteProject(projectName);

        // Verify deleted
        Assert.assertTrue(
                projectPage.isProjectDeleted(projectName),
                "Project was not deleted successfully."
        );

        System.out.println(
                "✅ Project Deleted Successfully"
        );
    }
}