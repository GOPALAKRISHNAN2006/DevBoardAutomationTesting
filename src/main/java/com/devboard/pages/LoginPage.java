package com.devboard.pages;
import com.devboard.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;

public class LoginPage extends BasePage{

    public LoginPage(WebDriver driver){
        super(driver);
    }

    private By emailTextbox = By.id("email");
    private By passwordTextbox = By.id("password");
    private By loginButton = By.id("loginBtn");

    public void enterEmail(String email){
        type(emailTextbox,email);
    }

    public void enterPassword(String password){
        type(passwordTextbox,password);
    }
    public void clickLogin(){
        click(loginButton);
    }
    public void login(String email,String password){
        enterEmail(email);
        enterPassword(password);
        clickLogin();
    }

}
