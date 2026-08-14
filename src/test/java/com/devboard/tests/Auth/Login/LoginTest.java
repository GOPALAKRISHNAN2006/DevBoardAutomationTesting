package com.devboard.tests.Auth.Login;

import com.devboard.base.BaseTest;
import com.devboard.config.ConfigReader;
import com.devboard.utils.WaitUtils;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.devboard.pages.DashboardPage;
import com.devboard.pages.LoginPage;
import testdata.LoginData;

public class LoginTest extends BaseTest{

    @Test(
            dataProvider = "loginData",
            dataProviderClass = LoginData.class
    )

    public void validLoginTest(String email,String password){

        driver.get(ConfigReader.getProperty("baseUrl")+"/login");

        LoginPage loginPage = new LoginPage(driver);

        loginPage.login(email,password);

        WaitUtils.waitForUrl(driver,"/dashboard");

        DashboardPage dashboardPage = new DashboardPage(driver);

        Assert.assertTrue(
                dashboardPage.isDashboardLoaded(),
                "Dashboard was not loaded successfully"
        );
      System.out.println("✅ Login Successful for : " + email);
    }
}
