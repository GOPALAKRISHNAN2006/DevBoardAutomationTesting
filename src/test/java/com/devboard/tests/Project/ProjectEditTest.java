package com.devboard.tests.Project;

import com.devboard.base.BaseTest;
import com.devboard.config.ConfigReader;
import com.devboard.pages.DashboardPage;
import com.devboard.pages.LoginPage;
import com.devboard.pages.ProjectPage;
import com.devboard.utils.WaitUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProjectEditTest extends BaseTest {

    @Test
    public void editProjectTest() {

        driver.get(ConfigReader.getProperty("baseUrl") + "/login");

        LoginPage loginPage = new LoginPage(driver);

        loginPage.login(
                "gopalmuruga001@gmail.com",
                "1234567890"
        );

        WaitUtils.waitForUrl(driver, "/dashboard");

        DashboardPage dashboardPage = new DashboardPage(driver);

        dashboardPage.goToProjects();

        ProjectPage projectPage = new ProjectPage(driver);

        String oldTitle = "DevBoard";

        String newTitle = "DevBoard Updated";

        projectPage.searchProject(oldTitle);

        projectPage.editProject(oldTitle, newTitle);

        Assert.assertTrue(
                projectPage.isProjectPresent(newTitle),
                "Project was not updated successfully."
        );

        System.out.println("✅ Project Updated Successfully");
    }
}