package com.devboard.pages;

import com.devboard.base.BasePage;
import com.devboard.utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GithubPage extends BasePage {

    public GithubPage(WebDriver driver) {
        super(driver);
    }

    private By pageTitle =
            By.cssSelector("[data-testid='github-page-title']");

    private By username =
            By.cssSelector("[data-testid='github-username']");

    private By repositoriesTitle =
            By.xpath("//h5[normalize-space()='All Repositories']");

    private By repositories =
            By.cssSelector("[data-testid^='github-repository-']");

    public boolean isGithubPageLoaded() {

        WaitUtils.waitForVisible(
                driver,
                pageTitle
        );

        return driver.getCurrentUrl()
                .contains("/github");
    }

    public boolean isUsernameDisplayed() {

        return driver.findElement(username)
                .isDisplayed();
    }

    public boolean isRepositoriesSectionDisplayed() {

        WaitUtils.waitForVisible(
                driver,
                repositoriesTitle
        );

        return true;
    }

    public String getUsernameText() {

        return driver.findElement(username)
                .getText();
    }

    public boolean areRepositoriesDisplayed() {

        WaitUtils.waitForVisible(
                driver,
                repositories
        );

        return !driver.findElements(repositories).isEmpty();
    }

}