package com.devboard.tests;

import com.devboard.base.BaseTest;
import com.devboard.config.ConfigReader;
import com.devboard.pages.DashboardPage;
import com.devboard.pages.LoginPage;
import com.devboard.utils.WaitUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SessionPersistenceTest extends BaseTest {

    @Test
    public void sessionPersistenceTest() {

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

        // Verify dashboard
        Assert.assertTrue(
                dashboardPage.isDashboardLoaded(),
                "Dashboard was not loaded after login."
        );

        System.out.println(
                "✅ Login Successful"
        );

        // Refresh browser
        driver.navigate().refresh();

        // Wait for dashboard
        WaitUtils.waitForUrl(
                driver,
                "/dashboard"
        );

        // Verify session is still active
        Assert.assertTrue(
                dashboardPage.isDashboardLoaded(),
                "User session was lost after refresh."
        );

        System.out.println(
                "✅ Session Persisted After Refresh"
        );

        System.out.println(
                "✅ Session Persistence Test Passed"
        );
    }

}