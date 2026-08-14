package com.devboard.tests;

import com.devboard.base.BaseTest;
import com.devboard.config.ConfigReader;
import com.devboard.pages.DashboardPage;
import com.devboard.pages.LoginPage;
import com.devboard.utils.WaitUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LogoutTest extends BaseTest {

    @Test
    public void logoutTest() {

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

        // Logout
        dashboardPage.clickLogout();

        // Wait for login page
        WaitUtils.waitForUrl(
                driver,
                "/login"
        );

        // Verify logout
        Assert.assertTrue(
                driver.getCurrentUrl().contains("/login"),
                "User was not redirected to login after logout."
        );

        System.out.println(
                "✅ Logout Redirected To Login Successfully"
        );

        // Try accessing protected dashboard
        driver.get(
                ConfigReader.getProperty("baseUrl") + "/dashboard"
        );

        // Verify user cannot access dashboard
        WaitUtils.waitForUrl(
                driver,
                "/login"
        );

        Assert.assertTrue(
                driver.getCurrentUrl().contains("/login"),
                "Protected dashboard was accessible after logout."
        );

        System.out.println(
                "✅ Protected Dashboard Blocked After Logout"
        );

        System.out.println(
                "✅ Logout Test Passed"
        );
    }
}