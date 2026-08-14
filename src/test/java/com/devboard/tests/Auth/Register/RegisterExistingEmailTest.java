package com.devboard.tests.Auth.Register;

import com.devboard.base.BaseTest;
import com.devboard.config.ConfigReader;
import com.devboard.pages.RegisterPage;
import com.devboard.utils.WaitUtils;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegisterExistingEmailTest extends BaseTest {

    @Test
    public void registerExistingEmailTest() {

        // Open register page
        driver.get(
                ConfigReader.getProperty("baseUrl") + "/register"
        );

        // Create register page
        RegisterPage registerPage =
                new RegisterPage(driver);

        // Enter existing user details
        registerPage.enterName(
                "Existing Test User"
        );

        registerPage.enterEmail(
                "gopalmuruga001@gmail.com"
        );

        registerPage.enterPassword(
                "1234567890"
        );

        // Click register
        registerPage.clickRegister();

        // Wait for response
        WaitUtils.waitForVisible(
                driver,
                By.tagName("body")
        );

        // Verify registration did not succeed
        Assert.assertFalse(
                driver.getCurrentUrl().contains("/dashboard"),
                "Existing email was registered successfully."
        );

        System.out.println(
                "✅ Existing Email Validation Passed"
        );
    }
}