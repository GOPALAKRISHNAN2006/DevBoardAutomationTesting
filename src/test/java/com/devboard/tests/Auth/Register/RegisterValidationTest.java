package com.devboard.tests.Auth.Register;

import com.devboard.base.BaseTest;
import com.devboard.config.ConfigReader;
import com.devboard.pages.RegisterPage;
import com.devboard.utils.WaitUtils;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class RegisterValidationTest extends BaseTest {

    @DataProvider(name = "registerValidationData")
    public Object[][] registerValidationData() {

        return new Object[][]{
                {"Test User", "invalid-email", "1234567890", "invalid email"},
                {"", "testregister@gmail.com", "1234567890", "empty name"},
                {"Test User", "", "1234567890", "empty email"},
                {"Test User", "testregister@gmail.com", "", "empty password"},
                {"", "", "", "all fields empty"}
        };
    }

    @Test(dataProvider = "registerValidationData")
    public void registerValidationTest(
            String name,
            String email,
            String password,
            String scenario
    ) {

        // Open register page
        driver.get(
                ConfigReader.getProperty("baseUrl") + "/register"
        );

        // Create register page
        RegisterPage registerPage =
                new RegisterPage(driver);

        // Enter name
        registerPage.enterName(name);

        // Enter email
        registerPage.enterEmail(email);

        // Enter password
        registerPage.enterPassword(password);

        // Click register
        registerPage.clickRegister();

        // Wait for response
        WaitUtils.waitForVisible(
                driver,
                By.tagName("body")
        );

        // Verify registration did not navigate to dashboard
        Assert.assertFalse(
                driver.getCurrentUrl().contains("/dashboard"),
                "Invalid registration succeeded for scenario: "
                        + scenario
        );

        System.out.println(
                "✅ " + scenario + " validation passed"
        );
    }
}