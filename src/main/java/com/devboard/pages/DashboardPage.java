package com.devboard.pages;

import com.devboard.base.BasePage;
import com.devboard.utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage extends BasePage {

    public DashboardPage(WebDriver driver) {
        super(driver);
    }

    // =========================================================
    // NAVIGATION LOCATORS
    // =========================================================

    private By notesButton =
            By.cssSelector("[data-testid='dashboard-notes-link']");

    private By newProjectButton =
            By.cssSelector("[data-testid='dashboard-new-project-button']");

    private By jobsButton =
            By.cssSelector("[data-testid='dashboard-jobs-link']");

    private By githubButton =
            By.cssSelector("[data-testid='dashboard-github-link']");

    private By leetcodeButton =
            By.cssSelector("[data-testid='dashboard-leetcode-link']");

    private By profileButton =
            By.cssSelector("[data-testid='dashboard-profile-link']");


    // =========================================================
    // DASHBOARD LOCATORS
    // =========================================================

    private By pageTitle =
            By.cssSelector("[data-testid='dashboard-page-title']");

    private By totalProjects =
            By.cssSelector("[data-testid='dashboard-total-projects']");

    private By totalJobs =
            By.cssSelector("[data-testid='dashboard-total-jobs']");

    private By totalSkills =
            By.cssSelector("[data-testid='dashboard-total-skills']");

    private By offers =
            By.cssSelector("[data-testid='dashboard-offers']");

    private By githubRepos =
            By.cssSelector("[data-testid='dashboard-github-repos']");

    private By githubStars =
            By.cssSelector("[data-testid='dashboard-github-stars']");

    private By leetcodeSolved =
            By.cssSelector("[data-testid='dashboard-leetcode-solved']");

    private By leetcodeRank =
            By.cssSelector("[data-testid='dashboard-leetcode-rank']");


    // =========================================================
    // DASHBOARD SECTION LOCATORS
    // =========================================================

    private By recentProjects =
            By.cssSelector("[data-testid='dashboard-recent-projects']");

    private By recentJobs =
            By.cssSelector("[data-testid='dashboard-recent-jobs']");

    private By recentGithub =
            By.cssSelector("[data-testid='dashboard-recent-github']");


    // =========================================================
    // DASHBOARD
    // =========================================================

    public boolean isDashboardLoaded() {

        WaitUtils.waitForVisible(
                driver,
                pageTitle
        );

        return driver.getCurrentUrl()
                .contains("/dashboard");
    }


    // =========================================================
    // STATISTICS
    // =========================================================

    public boolean isTotalProjectsDisplayed() {

        WaitUtils.waitForVisible(
                driver,
                totalProjects
        );

        return driver.findElement(totalProjects)
                .isDisplayed();
    }


    public boolean isTotalJobsDisplayed() {

        WaitUtils.waitForVisible(
                driver,
                totalJobs
        );

        return driver.findElement(totalJobs)
                .isDisplayed();
    }


    public boolean isTotalSkillsDisplayed() {

        WaitUtils.waitForVisible(
                driver,
                totalSkills
        );

        return driver.findElement(totalSkills)
                .isDisplayed();
    }


    public boolean isOffersDisplayed() {

        WaitUtils.waitForVisible(
                driver,
                offers
        );

        return driver.findElement(offers)
                .isDisplayed();
    }


    // =========================================================
    // GITHUB STATISTICS
    // =========================================================

    public boolean isGithubReposDisplayed() {

        WaitUtils.waitForVisible(
                driver,
                githubRepos
        );

        return driver.findElement(githubRepos)
                .isDisplayed();
    }


    public boolean isGithubStarsDisplayed() {

        WaitUtils.waitForVisible(
                driver,
                githubStars
        );

        return driver.findElement(githubStars)
                .isDisplayed();
    }


    // =========================================================
    // LEETCODE STATISTICS
    // =========================================================

    public boolean isLeetcodeSolvedDisplayed() {

        WaitUtils.waitForVisible(
                driver,
                leetcodeSolved
        );

        return driver.findElement(leetcodeSolved)
                .isDisplayed();
    }


    public boolean isLeetcodeRankDisplayed() {

        WaitUtils.waitForVisible(
                driver,
                leetcodeRank
        );

        return driver.findElement(leetcodeRank)
                .isDisplayed();
    }


    // =========================================================
    // RECENT PROJECTS
    // =========================================================

    public boolean isRecentProjectsDisplayed() {

        WaitUtils.waitForVisible(
                driver,
                recentProjects
        );

        return driver.findElement(recentProjects)
                .isDisplayed();
    }


    // =========================================================
    // RECENT JOBS
    // =========================================================

    public boolean isRecentJobsDisplayed() {

        WaitUtils.waitForVisible(
                driver,
                recentJobs
        );

        return driver.findElement(recentJobs)
                .isDisplayed();
    }


    // =========================================================
    // RECENT GITHUB
    // =========================================================

    public boolean isRecentGithubDisplayed() {

        WaitUtils.waitForVisible(
                driver,
                recentGithub
        );

        return driver.findElement(recentGithub)
                .isDisplayed();
    }


    // =========================================================
    // PROJECTS
    // =========================================================

    public void goToProjects() {

        WaitUtils.waitForVisible(
                driver,
                newProjectButton
        );

        click(newProjectButton);

        WaitUtils.waitForUrl(
                driver,
                "/projects"
        );
    }


    // =========================================================
    // JOBS
    // =========================================================

    public void goToJobs() {

        WaitUtils.waitForClickable(
                driver,
                jobsButton
        );

        click(jobsButton);

        WaitUtils.waitForUrl(
                driver,
                "/jobs"
        );
    }


    // =========================================================
    // NOTES
    // =========================================================

    public void goToNotes() {

        WaitUtils.waitForClickable(
                driver,
                notesButton
        );

        click(notesButton);

        WaitUtils.waitForUrl(
                driver,
                "/notes"
        );
    }


    // =========================================================
    // GITHUB
    // =========================================================

    public void goToGithub() {

        WaitUtils.waitForVisible(
                driver,
                githubButton
        );

        click(githubButton);

        WaitUtils.waitForUrl(
                driver,
                "/github"
        );
    }


    // =========================================================
    // LEETCODE
    // =========================================================

    public void goToLeetcode() {

        WaitUtils.waitForVisible(
                driver,
                leetcodeButton
        );

        click(leetcodeButton);

        WaitUtils.waitForUrl(
                driver,
                "/leetcode"
        );
    }


    // =========================================================
    // PROFILE
    // =========================================================

    public void goToProfile() {

        WaitUtils.waitForVisible(
                driver,
                profileButton
        );

        click(profileButton);

        WaitUtils.waitForUrl(
                driver,
                "/profile"
        );
    }
    public boolean isGithubStatsAvailable() {

        return !driver.findElements(githubRepos).isEmpty()
                && !driver.findElements(githubStars).isEmpty();
    }
    public boolean isLeetcodeStatsAvailable() {

        return !driver.findElements(leetcodeSolved).isEmpty()
                && !driver.findElements(leetcodeRank).isEmpty();
    }
    // RESUME
    private By resumeButton =
            By.cssSelector("[data-testid='dashboard-resume-link']");

    public void goToResume() {

        WaitUtils.waitForClickable(
                driver,
                resumeButton
        );

        click(resumeButton);

        WaitUtils.waitForUrl(
                driver,
                "/resume"
        );
    }

    // LOGOUT
    private By logoutButton =
            By.cssSelector("[data-testid='logout-button']");

    public void clickLogout() {

        WaitUtils.waitForClickable(
                driver,
                logoutButton
        );

        click(logoutButton);
    }
}