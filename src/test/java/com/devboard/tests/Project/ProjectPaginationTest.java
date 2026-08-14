package com.devboard.tests.Project;

import com.devboard.base.BaseTest;
import com.devboard.config.ConfigReader;
import com.devboard.pages.DashboardPage;
import com.devboard.pages.LoginPage;
import com.devboard.pages.ProjectPage;
import com.devboard.utils.WaitUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProjectPaginationTest extends BaseTest {

    @Test
    public void paginationTest() {

        // Login
        driver.get(
                ConfigReader.getProperty("baseUrl") + "/login"
        );

        LoginPage loginPage =
                new LoginPage(driver);

        loginPage.login(
                "gopalmuruga001@gmail.com",
                "1234567890"
        );

        WaitUtils.waitForUrl(driver, "/dashboard");

        // Dashboard → Projects
        DashboardPage dashboardPage =
                new DashboardPage(driver);

        dashboardPage.goToProjects();

        WaitUtils.waitForUrl(driver, "/projects");

        // Projects
        ProjectPage projectPage =
                new ProjectPage(driver);

        // Verify first page
        Assert.assertEquals(
                projectPage.getCurrentPage(),
                "1",
                "First page should be active."
        );

        // Go to page 2
        projectPage.clickPage(2);

        // Verify page 2
        Assert.assertEquals(
                projectPage.getCurrentPage(),
                "2",
                "Second page should be active."
        );

        System.out.println(
                "✅ Pagination test passed"
        );
    }
}