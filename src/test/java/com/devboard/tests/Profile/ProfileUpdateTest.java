package com.devboard.tests.Profile;

import com.devboard.base.BaseTest;
import com.devboard.config.ConfigReader;
import com.devboard.pages.DashboardPage;
import com.devboard.pages.LoginPage;
import com.devboard.pages.ProfilePage;
import com.devboard.utils.WaitUtils;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProfileUpdateTest extends BaseTest {

    @Test
    public void profileUpdateTest() {

        // ==========================================
        // LOGIN
        // ==========================================

        driver.get(
                ConfigReader.getProperty("baseUrl") + "/login"
        );

        LoginPage loginPage =
                new LoginPage(driver);

        loginPage.login(
                "gopalmuruga001@gmail.com",
                "1234567890"
        );

        // ==========================================
        // DASHBOARD
        // ==========================================

        WaitUtils.waitForUrl(
                driver,
                "/dashboard"
        );

        DashboardPage dashboardPage =
                new DashboardPage(driver);

        dashboardPage.goToProfile();

        WaitUtils.waitForUrl(
                driver,
                "/profile"
        );

        // ==========================================
        // PROFILE PAGE
        // ==========================================

        ProfilePage profilePage =
                new ProfilePage(driver);

        Assert.assertTrue(
                profilePage.isProfilePageLoaded(),
                "Profile page was not loaded."
        );

        System.out.println(
                "✅ Profile Page Loaded Successfully"
        );

        // ==========================================
        // VERIFY EXISTING FIELDS
        // ==========================================

        Assert.assertTrue(
                profilePage.isNameFieldDisplayed(),
                "Name field was not displayed."
        );

        Assert.assertTrue(
                profilePage.isEmailFieldDisplayed(),
                "Email field was not displayed."
        );

        Assert.assertTrue(
                profilePage.isLocationFieldDisplayed(),
                "Location field was not displayed."
        );

        Assert.assertTrue(
                profilePage.isSkillsFieldDisplayed(),
                "Skills field was not displayed."
        );

        Assert.assertTrue(
                profilePage.isBioFieldDisplayed(),
                "Bio field was not displayed."
        );

        System.out.println(
                "✅ Profile Fields Displayed Successfully"
        );

        // ==========================================
        // VERIFY EMAIL
        // ==========================================

        Assert.assertEquals(
                profilePage.getEmail(),
                "gopalmuruga001@gmail.com",
                "Incorrect email displayed."
        );

        System.out.println(
                "✅ Profile Email Verified"
        );

        // ==========================================
        // UPDATE PROFILE
        // ==========================================

        String updatedName =
                "Gopalakrishnan Test";

        String updatedLocation =
                "Coimbatore, India";

        String updatedSkills =
                "Java, Selenium, React, Node.js";

        String updatedBio =
                "Software developer testing DevBoard automation.";

        profilePage.enterName(
                updatedName
        );

        profilePage.enterLocation(
                updatedLocation
        );

        profilePage.enterSkills(
                updatedSkills
        );

        profilePage.enterBio(
                updatedBio
        );

        System.out.println(
                "✅ Profile Details Entered Successfully"
        );

        // ==========================================
        // SAVE
        // ==========================================

        profilePage.clickSave();

        System.out.println(
                "✅ Profile Save Button Clicked"
        );

        // Give backend/API time to complete
        WaitUtils.waitForVisible(
                driver,
                By.cssSelector("[data-testid='profile-display-name']")
        );

        // ==========================================
        // VERIFY UPDATED DATA
        // ==========================================

        Assert.assertTrue(
                profilePage.isDisplayedNameCorrect(
                        updatedName
                ),
                "Updated name was not displayed."
        );

        Assert.assertTrue(
                profilePage.isDisplayedLocationCorrect(
                        updatedLocation
                ),
                "Updated location was not displayed."
        );

        System.out.println(
                "✅ Profile Updated Successfully"
        );

        // ==========================================
        // REFRESH PAGE
        // ==========================================

        driver.navigate().refresh();

        WaitUtils.waitForUrl(
                driver,
                "/profile"
        );

        // ==========================================
        // VERIFY DATA PERSISTED
        // ==========================================

        Assert.assertEquals(
                profilePage.getName(),
                updatedName,
                "Updated name was not persisted."
        );

        Assert.assertEquals(
                profilePage.getLocation(),
                updatedLocation,
                "Updated location was not persisted."
        );

        Assert.assertEquals(
                profilePage.getSkills(),
                updatedSkills,
                "Updated skills were not persisted."
        );

        Assert.assertEquals(
                profilePage.getBio(),
                updatedBio,
                "Updated bio was not persisted."
        );

        System.out.println(
                "✅ Profile Data Persisted Successfully"
        );

        // ==========================================
        // FINAL RESULT
        // ==========================================

        System.out.println(
                "✅ Profile Update Test Passed"
        );
    }
}