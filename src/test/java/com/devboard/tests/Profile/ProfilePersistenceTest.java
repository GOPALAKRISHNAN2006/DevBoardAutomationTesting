package com.devboard.tests.Profile;

import com.devboard.base.BaseTest;
import com.devboard.config.ConfigReader;
import com.devboard.pages.DashboardPage;
import com.devboard.pages.LoginPage;
import com.devboard.pages.ProfilePage;
import com.devboard.utils.WaitUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProfilePersistenceTest extends BaseTest {

    @Test
    public void profilePersistenceTest() {

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

        System.out.println(
                "✅ Profile Page Loaded Successfully"
        );

        // Test data
        String name =
                "Gopal Persistence Test";

        String location =
                "Coimbatore";

        String skills =
                "Java, Selenium, TestNG";

        String bio =
                "Testing profile persistence with Selenium.";

        String github =
                "GOPALAKRISHNAN2006";

        String leetcode =
                "krishna_k3";

        // Update profile
        profilePage.enterName(name);

        profilePage.enterLocation(location);

        profilePage.enterSkills(skills);

        profilePage.enterBio(bio);

        profilePage.enterGithubUsername(github);

        profilePage.enterLeetcodeUsername(leetcode);

        // Save profile
        profilePage.clickSave();

        System.out.println(
                "✅ Profile Saved Successfully"
        );

        // Verify saved values
        Assert.assertEquals(
                profilePage.getName(),
                name,
                "Name was not saved."
        );

        Assert.assertEquals(
                profilePage.getLocation(),
                location,
                "Location was not saved."
        );

        Assert.assertEquals(
                profilePage.getSkills(),
                skills,
                "Skills were not saved."
        );

        Assert.assertEquals(
                profilePage.getBio(),
                bio,
                "Bio was not saved."
        );

        Assert.assertEquals(
                profilePage.getGithubUsername(),
                github,
                "GitHub username was not saved."
        );

        Assert.assertEquals(
                profilePage.getLeetcodeUsername(),
                leetcode,
                "LeetCode username was not saved."
        );

        System.out.println(
                "✅ Profile Data Saved Successfully"
        );

        // Refresh page
        driver.navigate().refresh();

        // Wait for profile page
        WaitUtils.waitForUrl(
                driver,
                "/profile"
        );

        // Verify persisted name
        Assert.assertEquals(
                profilePage.getName(),
                name,
                "Name was not persisted after refresh."
        );

        // Verify persisted location
        Assert.assertEquals(
                profilePage.getLocation(),
                location,
                "Location was not persisted after refresh."
        );

        // Verify persisted skills
        Assert.assertEquals(
                profilePage.getSkills(),
                skills,
                "Skills were not persisted after refresh."
        );

        // Verify persisted bio
        Assert.assertEquals(
                profilePage.getBio(),
                bio,
                "Bio was not persisted after refresh."
        );

        // Verify persisted GitHub username
        Assert.assertEquals(
                profilePage.getGithubUsername(),
                github,
                "GitHub username was not persisted after refresh."
        );

        // Verify persisted LeetCode username
        Assert.assertEquals(
                profilePage.getLeetcodeUsername(),
                leetcode,
                "LeetCode username was not persisted after refresh."
        );

        System.out.println(
                "✅ Profile Data Persisted Successfully"
        );

        // Final result
        System.out.println(
                "✅ Profile Persistence Test Passed"
        );
    }
}