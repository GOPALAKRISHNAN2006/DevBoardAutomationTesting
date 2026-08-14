package com.devboard.tests.Auth.Register;
import com.devboard.base.BaseTest;
import com.devboard.config.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.devboard.pages.RegisterPage;
import com.devboard.utils.WaitUtils;

public class RegisterTest extends BaseTest{

    @Test
    public void validRegistrationTest(){

        driver.get(ConfigReader.getProperty("baseUrl")+"/register");

        RegisterPage registerPage = new RegisterPage(driver);

        String email = "gopal" + System.currentTimeMillis() + "@gmail.com";

        registerPage.register(
                "GopalaKrishnan",email,"12345678"
        );

        WaitUtils.waitForUrl(driver,"/login");
        Assert.assertTrue(
                driver.getCurrentUrl().contains("/login"),
                "User was not redirected to Login page."
        );
        System.out.println("✅ Registration Successful : " + email);


    }
}
