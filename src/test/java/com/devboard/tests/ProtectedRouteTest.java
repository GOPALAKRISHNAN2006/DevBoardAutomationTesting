package com.devboard.tests;

import com.devboard.base.BaseTest;
import com.devboard.config.ConfigReader;
import com.devboard.utils.WaitUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProtectedRouteTest extends BaseTest {

    @Test
    public void protectedDashboardTest() {

        // Open protected dashboard without login
        driver.get(
                ConfigReader.getProperty("baseUrl") + "/dashboard"
        );

        // Wait for login page
        WaitUtils.waitForUrl(
                driver,
                "/login"
        );

        // Verify redirect to login
        Assert.assertTrue(
                driver.getCurrentUrl().contains("/login"),
                "Unauthenticated user was able to access dashboard."
        );

        System.out.println(
                "✅ Protected Dashboard Redirected To Login"
        );

        System.out.println(
                "✅ Protected Route Test Passed"
        );
    }
}