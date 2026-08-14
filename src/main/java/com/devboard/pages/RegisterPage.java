package com.devboard.pages;
import com.devboard.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;

public class RegisterPage extends BasePage{
    public RegisterPage(WebDriver driver){
        super(driver);
    }
    private By nameTextbox = By.id("register-name");
    private By emailTextbox = By.id("register-email");
    private By passwordTextbox = By.id("register-password");
    private By registerButton = By.id("register-btn");


    public void enterName(String name) {
        type(nameTextbox, name);
    }

    public void enterEmail(String email) {
        type(emailTextbox, email);
    }

    public void enterPassword(String password) {
        type(passwordTextbox, password);
    }

    public void clickRegister() {
        click(registerButton);
    }
    public void register(String name,String email,String password){
        enterName(name);
        enterEmail(email);
        enterPassword(password);
        clickRegister();
    }
}
