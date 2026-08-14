package com.devboard.tests;
import com.devboard.base.BaseTest;
import com.devboard.config.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.devboard.pages.DashboardPage;
import com.devboard.pages.LoginPage;
import com.devboard.pages.RegisterPage;
import com.devboard.utils.WaitUtils;
public class EndToEndTest extends BaseTest {

    @Test
    public void RegisterAndLoginTest(){

        String email = "gopal"+System.currentTimeMillis()+"@gmail.com";
        String password = "Test@123";

        // Register
        driver.get(ConfigReader.getProperty("baseUrl")+"/register");
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.register("Gokul",email,password);
        WaitUtils.waitForUrl(driver,"/login");
        Assert.assertTrue(driver.getCurrentUrl().contains("/login"),
                "Registration Failed");


        //Login
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(email,password);
        WaitUtils.waitForUrl(driver,"/dashboard");
        DashboardPage dashboardPage = new DashboardPage(driver);

        Assert.assertTrue(dashboardPage.isDashboardLoaded(),
                "Dashboard not loaded!");

        System.out.println("✅ End-to-End Test Passed");
    }
}
