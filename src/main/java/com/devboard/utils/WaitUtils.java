package com.devboard.utils;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtils {

    public static void waitForUrl(WebDriver driver, String url) {

        WebDriverWait wait =
                new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.urlContains(url));
    }

    public static void waitForVisible(WebDriver driver, By locator) {

        WebDriverWait wait =
                new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(locator)
        );
    }

    public static void waitForInvisible(WebDriver driver, By locator) {

        WebDriverWait wait =
                new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(
                ExpectedConditions.invisibilityOfElementLocated(locator)
        );
    }

    public static boolean waitForElementToDisappear(
            WebDriver driver,
            By locator) {

        WebDriverWait wait =
                new WebDriverWait(driver, Duration.ofSeconds(10));

        return wait.until(
                ExpectedConditions.invisibilityOfElementLocated(locator)
        );
    }
    public static void waitForClickable(
            WebDriver driver,
            By locator) {

        new WebDriverWait(
                driver,
                Duration.ofSeconds(10)
        ).until(
                ExpectedConditions.elementToBeClickable(locator)
        );
    }
    public static void waitForAlert(WebDriver driver) {

        WebDriverWait wait =
                new WebDriverWait(
                        driver,
                        Duration.ofSeconds(10)
                );

        wait.until(
                ExpectedConditions.alertIsPresent()
        );
    }
}