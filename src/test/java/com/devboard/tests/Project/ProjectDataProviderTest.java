package com.devboard.tests.Project;

import com.devboard.base.BaseTest;
import com.devboard.config.ConfigReader;
import com.devboard.pages.DashboardPage;
import com.devboard.pages.LoginPage;
import com.devboard.pages.ProjectPage;
import com.devboard.utils.WaitUtils;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ProjectDataProviderTest extends BaseTest {

    @DataProvider(name = "projectValidationData")
    public Object[][] projectValidationData() {

        return new Object[][]{
                {"", "Project description", true, false, "empty title"},
                {"Data Provider Project", "", false, true, "empty description"},
                {"", "", true, true, "empty title and description"}
        };
    }

    @Test(dataProvider = "projectValidationData")
    public void projectValidationTest(
            String title,
            String description,
            boolean titleInvalid,
            boolean descriptionInvalid,
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

        // Navigate to projects
        dashboardPage.goToProjects();

        // Wait for projects page
        WaitUtils.waitForUrl(
                driver,
                "/projects"
        );

        // Create project page
        ProjectPage projectPage =
                new ProjectPage(driver);

        // Open project form
        projectPage.clickAddProject();

        // Enter title
        projectPage.enterTitle(title);

        // Enter description
        projectPage.enterDescription(description);

        // Enter tech stack
        projectPage.enterTechStack(
                "Java, Selenium"
        );

        // Enter GitHub URL
        projectPage.enterGithub(
                "https://github.com/test/project"
        );

        // Enter live URL
        projectPage.enterLiveUrl(
                "https://example.com"
        );

        // Select status
        projectPage.selectStatus(
                "In Progress"
        );

        // Click save
        projectPage.clickSaveWithoutWaiting();

        // Verify title validation
        if (titleInvalid) {

            Assert.assertTrue(
                    projectPage.isTitleInvalid(),
                    "Title validation was not triggered for: "
                            + scenario
            );
        }

        // Verify description validation
        if (descriptionInvalid) {

            Assert.assertTrue(
                    projectPage.isDescriptionInvalid(),
                    "Description validation was not triggered for: "
                            + scenario
            );
        }

        System.out.println(
                "✅ Project " + scenario + " validation passed"
        );
    }
}