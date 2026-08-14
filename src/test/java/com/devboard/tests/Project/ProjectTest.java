package com.devboard.tests.Project;

import com.devboard.base.BaseTest;
import com.devboard.config.ConfigReader;
import com.devboard.pages.DashboardPage;
import com.devboard.pages.LoginPage;
import com.devboard.pages.ProjectPage;
import com.devboard.utils.WaitUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProjectTest extends BaseTest {

    @Test
    public void addProjectTest() {


        // Open Login Page
        driver.get(ConfigReader.getProperty("baseUrl") + "/login");

        // Login
        LoginPage loginPage = new LoginPage(driver);

        loginPage.login(
                "gopalmuruga001@gmail.com",
                "1234567890"
        );

        // Wait for Dashboard
        WaitUtils.waitForUrl(driver, "/dashboard");

        // Navigate to Projects
        DashboardPage dashboardPage = new DashboardPage(driver);

        dashboardPage.goToProjects();

        // Wait for Projects Page
        WaitUtils.waitForUrl(driver, "/projects");

        // Create Project Page
        ProjectPage projectPage = new ProjectPage(driver);

        // Unique Project Name
        String projectName = "DevBoard "+ System.currentTimeMillis();

        // Add Project
        projectPage.addProject(
                projectName,
                "Developer Dashboard using MERN",
                "React,Node.js,Express,MongoDB",
                "https://github.com/demo",
                "https://demo.com",
                "Planned"
        );



        // Verify
        Assert.assertTrue(
                projectPage.isProjectPresent(projectName),
                "Project was not created successfully."
        );

        System.out.println("✅ Project Created Successfully");

    }

}