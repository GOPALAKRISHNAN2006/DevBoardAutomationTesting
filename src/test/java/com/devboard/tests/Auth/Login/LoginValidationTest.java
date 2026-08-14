package com.devboard.tests.Auth.Login;

import com.devboard.base.BaseTest;
import com.devboard.config.ConfigReader;
import com.devboard.pages.LoginPage;
import com.devboard.utils.WaitUtils;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginValidationTest extends BaseTest {

    // Login validation test data
    @DataProvider(name = "loginValidationData")
    public Object[][] loginValidationData() {

        return new Object[][]{
                {"wrong@gmail.com", "1234567890", "invalid email"},
                {"gopalmuruga001@gmail.com", "wrongpassword", "invalid password"},
                {"", "1234567890", "empty email"},
                {"gopalmuruga001@gmail.com", "", "empty password"},
                {"", "", "empty email and password"}
        };
    }

    // Test invalid login combinations
    @Test(dataProvider = "loginValidationData")
    public void loginValidationTest(
            String email,
            String password,
            String scenario
    ) {

        // Open login page
        driver.get(
                ConfigReader.getProperty("baseUrl") + "/login"
        );

        // Create login page
        LoginPage loginPage =
                new LoginPage(driver);

        // Enter email
        loginPage.enterEmail(email);

        // Enter password
        loginPage.enterPassword(password);

        // Click login
        loginPage.clickLogin();

        // Wait for response
        WaitUtils.waitForVisible(
                driver,
                By.tagName("body")
        );

        // Verify login did not succeed
        Assert.assertTrue(
                driver.getCurrentUrl().contains("/login"),
                "Invalid login succeeded for scenario: " + scenario
        );

        System.out.println(
                "✅ " + scenario + " validation passed"
        );
    }
}