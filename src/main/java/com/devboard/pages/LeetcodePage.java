package com.devboard.pages;

import com.devboard.base.BasePage;
import com.devboard.utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LeetcodePage extends BasePage {

    public LeetcodePage(WebDriver driver) {
        super(driver);
    }

    private By pageTitle =
            By.cssSelector("[data-testid='leetcode-page-title']");

    private By username =
            By.cssSelector("[data-testid='leetcode-username']");

    private By profileCard =
            By.cssSelector("[data-testid='leetcode-profile-card']");

    private By totalSolved =
            By.cssSelector("[data-testid='leetcode-value-total-solved']");

    private By easySolved =
            By.cssSelector("[data-testid='leetcode-value-easy']");

    private By mediumSolved =
            By.cssSelector("[data-testid='leetcode-value-medium']");

    private By hardSolved =
            By.cssSelector("[data-testid='leetcode-value-hard']");

    private By openProfileButton =
            By.cssSelector("[data-testid='leetcode-open-profile']");


    public boolean isLeetcodePageLoaded() {

        WaitUtils.waitForVisible(
                driver,
                pageTitle
        );

        return driver.getCurrentUrl()
                .contains("/leetcode");
    }


    public boolean isProfileDisplayed() {

        WaitUtils.waitForVisible(
                driver,
                profileCard
        );

        return true;
    }


    public boolean isUsernameDisplayed() {

        WaitUtils.waitForVisible(
                driver,
                username
        );

        return driver.findElement(username)
                .isDisplayed();
    }


    public boolean isTotalSolvedDisplayed() {

        WaitUtils.waitForVisible(
                driver,
                totalSolved
        );

        return driver.findElement(totalSolved)
                .isDisplayed();
    }


    public boolean areDifficultyStatsDisplayed() {

        WaitUtils.waitForVisible(
                driver,
                easySolved
        );

        WaitUtils.waitForVisible(
                driver,
                mediumSolved
        );

        WaitUtils.waitForVisible(
                driver,
                hardSolved
        );

        return true;
    }


    public boolean isOpenProfileButtonDisplayed() {

        WaitUtils.waitForVisible(
                driver,
                openProfileButton
        );

        return driver.findElement(openProfileButton)
                .isDisplayed();
    }

    public String getUsernameText() {

        return driver.findElement(username)
                .getText();
    }

    public String getTotalSolvedText() {

        return driver.findElement(totalSolved)
                .getText();
    }
}