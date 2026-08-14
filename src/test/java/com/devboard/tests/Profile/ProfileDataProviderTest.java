package com.devboard.tests.Profile;

import com.devboard.base.BaseTest;
import com.devboard.config.ConfigReader;
import com.devboard.pages.DashboardPage;
import com.devboard.pages.LoginPage;
import com.devboard.pages.ProfilePage;
import com.devboard.utils.WaitUtils;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ProfileDataProviderTest extends BaseTest {

    @DataProvider(name = "profileData")
    public Object[][] profileData() {

        return new Object[][]{
                {
                        "Gopal Test User",
                        "Chennai",
                        "Java, Selenium",
                        "Software testing profile",
                        "GOPALAKRISHNAN2006",
                        "krishna_k3",
                        "Profile basic data"
                },
                {
                        "Gopal Automation",
                        "Coimbatore",
                        "Java, TestNG, Selenium",
                        "Automation testing profile",
                        "GOPALAKRISHNAN2006",
                        "krishna_k3",
                        "Profile automation data"
                }
        };
    }

    @Test(dataProvider = "profileData")
    public void profileDataProviderTest(
            String name,
            String location,
            String skills,
            String bio,
            String github,
            String leetcode,
            String scenario
    ) {

        // Open login page
        driver.get(
                ConfigReader.getProperty("baseUrl") + "/login"
        );

        // Login
        LoginPage loginPage =
                new LoginPage(driver);

        loginPage.login(
                "gopalmuruga001@gmail.com",
                "1234567890"
        );

        // Wait for dashboard
        WaitUtils.waitForUrl(
                driver,
                "/dashboard"
        );

        // Create dashboard page
        DashboardPage dashboardPage =
                new DashboardPage(driver);

        // Navigate to profile
        dashboardPage.goToProfile();

        // Wait for profile page
        WaitUtils.waitForUrl(
                driver,
                "/profile"
        );

        // Create profile page
        ProfilePage profilePage =
                new ProfilePage(driver);

        // Verify profile page
        Assert.assertTrue(
                profilePage.isProfilePageLoaded(),
                "Profile page was not loaded."
        );

        // Update name
        profilePage.enterName(name);

        // Update location
        profilePage.enterLocation(location);

        // Update skills
        profilePage.enterSkills(skills);

        // Update bio
        profilePage.enterBio(bio);

        // Update GitHub username
        profilePage.enterGithubUsername(github);

        // Update LeetCode username
        profilePage.enterLeetcodeUsername(leetcode);

        // Save profile
        profilePage.clickSave();

        // Verify name
        Assert.assertEquals(
                profilePage.getName(),
                name,
                "Profile name was not updated for: " + scenario
        );

        // Verify location
        Assert.assertEquals(
                profilePage.getLocation(),
                location,
                "Profile location was not updated for: " + scenario
        );

        // Verify skills
        Assert.assertEquals(
                profilePage.getSkills(),
                skills,
                "Profile skills were not updated for: " + scenario
        );

        // Verify bio
        Assert.assertEquals(
                profilePage.getBio(),
                bio,
                "Profile bio was not updated for: " + scenario
        );

        // Verify GitHub username
        Assert.assertEquals(
                profilePage.getGithubUsername(),
                github,
                "GitHub username was not updated for: " + scenario
        );

        // Verify LeetCode username
        Assert.assertEquals(
                profilePage.getLeetcodeUsername(),
                leetcode,
                "LeetCode username was not updated for: " + scenario
        );

        System.out.println(
                "✅ " + scenario + " passed"
        );
    }
}