package com.devboard.pages;

import com.devboard.base.BasePage;
import com.devboard.utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProfilePage extends BasePage {

    public ProfilePage(WebDriver driver) {
        super(driver);
    }

    private By pageTitle =
            By.cssSelector("[data-testid='profile-page-title']");

    private By nameInput =
            By.cssSelector("[data-testid='profile-name-input']");

    private By emailInput =
            By.cssSelector("[data-testid='profile-email-input']");

    private By locationInput =
            By.cssSelector("[data-testid='profile-location-input']");

    private By skillsInput =
            By.cssSelector("[data-testid='profile-skills-input']");

    private By bioInput =
            By.cssSelector("[data-testid='profile-bio-input']");

    private By githubInput =
            By.cssSelector("[data-testid='profile-github-input']");

    private By leetcodeInput =
            By.cssSelector("[data-testid='profile-leetcode-input']");

    private By saveButton =
            By.cssSelector("[data-testid='profile-save-button']");

    private By displayName =
            By.cssSelector("[data-testid='profile-display-name']");

    private By displayEmail =
            By.cssSelector("[data-testid='profile-display-email']");

    private By displayLocation =
            By.cssSelector("[data-testid='profile-display-location']");


    // ==========================================
    // PAGE
    // ==========================================

    public boolean isProfilePageLoaded() {

        WaitUtils.waitForVisible(
                driver,
                pageTitle
        );

        return driver.getCurrentUrl()
                .contains("/profile");
    }


    // ==========================================
    // FIELD VISIBILITY
    // ==========================================

    public boolean isNameFieldDisplayed() {

        return driver.findElement(nameInput)
                .isDisplayed();
    }

    public boolean isEmailFieldDisplayed() {

        return driver.findElement(emailInput)
                .isDisplayed();
    }

    public boolean isLocationFieldDisplayed() {

        return driver.findElement(locationInput)
                .isDisplayed();
    }

    public boolean isSkillsFieldDisplayed() {

        return driver.findElement(skillsInput)
                .isDisplayed();
    }

    public boolean isBioFieldDisplayed() {

        return driver.findElement(bioInput)
                .isDisplayed();
    }


    // ==========================================
    // GET VALUES
    // ==========================================

    public String getName() {

        WaitUtils.waitForVisible(
                driver,
                nameInput
        );

        return driver.findElement(nameInput)
                .getAttribute("value");
    }

    public String getEmail() {

        WaitUtils.waitForVisible(
                driver,
                emailInput
        );

        return driver.findElement(emailInput)
                .getAttribute("value");
    }

    public String getLocation() {

        WaitUtils.waitForVisible(
                driver,
                locationInput
        );

        return driver.findElement(locationInput)
                .getAttribute("value");
    }

    public String getSkills() {

        WaitUtils.waitForVisible(
                driver,
                skillsInput
        );

        return driver.findElement(skillsInput)
                .getAttribute("value");
    }

    public String getBio() {

        WaitUtils.waitForVisible(
                driver,
                bioInput
        );

        return driver.findElement(bioInput)
                .getAttribute("value");
    }

    public String getGithubUsername() {

        WaitUtils.waitForVisible(
                driver,
                githubInput
        );

        return driver.findElement(githubInput)
                .getAttribute("value");
    }

    public String getLeetcodeUsername() {

        WaitUtils.waitForVisible(
                driver,
                leetcodeInput
        );

        return driver.findElement(leetcodeInput)
                .getAttribute("value");
    }


    // ==========================================
    // UPDATE FIELDS
    // ==========================================

    public void enterName(String name) {

        WaitUtils.waitForVisible(
                driver,
                nameInput
        );

        driver.findElement(nameInput)
                .clear();

        driver.findElement(nameInput)
                .sendKeys(name);
    }

    public void enterLocation(String location) {

        driver.findElement(locationInput)
                .clear();

        driver.findElement(locationInput)
                .sendKeys(location);
    }

    public void enterSkills(String skills) {

        driver.findElement(skillsInput)
                .clear();

        driver.findElement(skillsInput)
                .sendKeys(skills);
    }

    public void enterBio(String bio) {

        driver.findElement(bioInput)
                .clear();

        driver.findElement(bioInput)
                .sendKeys(bio);
    }

    public void enterGithubUsername(String username) {

        driver.findElement(githubInput)
                .clear();

        driver.findElement(githubInput)
                .sendKeys(username);
    }

    public void enterLeetcodeUsername(String username) {

        driver.findElement(leetcodeInput)
                .clear();

        driver.findElement(leetcodeInput)
                .sendKeys(username);
    }


    // ==========================================
    // SAVE
    // ==========================================

    public void clickSave() {

        WaitUtils.waitForClickable(
                driver,
                saveButton
        );

        click(saveButton);
    }


    // ==========================================
    // DISPLAYED USER INFORMATION
    // ==========================================

    public boolean isDisplayedNameCorrect(String expected) {

        WaitUtils.waitForVisible(
                driver,
                displayName
        );

        return driver.findElement(displayName)
                .getText()
                .equals(expected);
    }

    public boolean isDisplayedEmailCorrect(String expected) {

        return driver.findElement(displayEmail)
                .getText()
                .equals(expected);
    }

    public boolean isDisplayedLocationCorrect(String expected) {

        WaitUtils.waitForVisible(
                driver,
                displayLocation
        );

        return driver.findElement(displayLocation)
                .getText()
                .contains(expected);
    }
}