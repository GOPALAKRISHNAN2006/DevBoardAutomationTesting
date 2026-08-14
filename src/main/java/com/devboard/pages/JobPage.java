package com.devboard.pages;

import com.devboard.base.BasePage;
import com.devboard.utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class JobPage extends BasePage {

    public JobPage(WebDriver driver) {
        super(driver);
    }

    // Buttons
    private By addJobButton =
            By.cssSelector("[data-testid='add-job-button']");

    private By saveJobButton =
            By.cssSelector("[data-testid='save-job-button']");

    // Form fields
    private By companyInput =
            By.cssSelector("[data-testid='job-company-input']");

    private By roleInput =
            By.cssSelector("[data-testid='job-role-input']");

    private By locationInput =
            By.cssSelector("[data-testid='job-location-input']");

    private By jobTypeSelect =
            By.cssSelector("[data-testid='job-type-select']");

    private By statusSelect =
            By.cssSelector("[data-testid='job-status-select']");

    private By notesInput =
            By.cssSelector("[data-testid='job-notes-input']");


    // Click Add Job
    public void clickAddJob() {

        WaitUtils.waitForVisible(
                driver,
                addJobButton
        );

        click(addJobButton);
    }


    // Enter Company
    public void enterCompany(String company) {

        WaitUtils.waitForVisible(
                driver,
                companyInput
        );

        type(companyInput, company);
    }


    // Enter Role
    public void enterRole(String role) {

        type(roleInput, role);
    }


    // Enter Location
    public void enterLocation(String location) {

        type(locationInput, location);
    }


    // Select Job Type
    public void selectJobType(String jobType) {

        Select select =
                new Select(
                        driver.findElement(jobTypeSelect)
                );

        select.selectByVisibleText(jobType);
    }


    // Select Status
    public void selectStatus(String status) {

        Select select =
                new Select(
                        driver.findElement(statusSelect)
                );

        select.selectByVisibleText(status);
    }


    // Enter Notes
    public void enterNotes(String notes) {

        type(notesInput, notes);
    }


    // Save
    public void clickSave() {

        click(saveJobButton);
    }


    // Complete Add Job flow
    public void addJob(
            String company,
            String role,
            String location,
            String jobType,
            String status,
            String notes) {

        clickAddJob();

        enterCompany(company);

        enterRole(role);

        enterLocation(location);

        selectJobType(jobType);

        selectStatus(status);

        enterNotes(notes);

        clickSave();
    }


    // Verify job exists
    public boolean isJobPresent(String company, String role) {

        By jobRow = By.xpath(
                "//tr[" +
                        ".//strong[contains(text(),'" + role + "')]" +
                        " and " +
                        ".//div[contains(text(),'" + company + "')]" +
                        "]"
        );

        try {
            WaitUtils.waitForVisible(driver, jobRow);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    //Search Job
    public void searchJob(String searchText) {
        By searchInput =
                By.cssSelector("[data-testid='jobs-search-input']");
        WaitUtils.waitForVisible(driver, searchInput);
        type(searchInput, searchText);
    }

    public void clickEditJob(String company, String role) {

        By editButton = By.xpath(
                "//tr[" +
                        ".//strong[contains(text(),'" + role + "')]" +
                        " and " +
                        ".//div[contains(text(),'" + company + "')]" +
                        "]" +
                        "//button[contains(@data-testid,'edit-job-')]"
        );

        WaitUtils.waitForVisible(driver, editButton);
        click(editButton);
    }
    public void updateRole(String newRole) {

        WaitUtils.waitForVisible(driver, roleInput);

        type(roleInput, newRole);
    }
    public void editJob(
            String company,
            String oldRole,
            String newRole) {

        clickEditJob(company, oldRole);

        updateRole(newRole);

        clickSave();
    }

    // Delete Job
    public void clickDeleteJob(String company, String role) {

        By deleteButton = By.xpath(
                "//tr[" +
                        ".//strong[contains(text(),'" + role + "')]" +
                        " and " +
                        ".//div[contains(text(),'" + company + "')]" +
                        "]" +
                        "//button[contains(@data-testid,'delete-job-')]"
        );

        WaitUtils.waitForClickable(driver, deleteButton);

        click(deleteButton);
    }

    public boolean isJobFormDisplayed() {

        By jobForm =
                By.cssSelector("[data-testid='job-form']");

        return isDisplayed(jobForm);
    }
    // Filter Status
    public void filterByStatus(String status) {

        By statusFilter =
                By.cssSelector("[data-testid='jobs-status-filter']");

        WaitUtils.waitForClickable(driver, statusFilter);

        Select select =
                new Select(driver.findElement(statusFilter));

        select.selectByVisibleText(status);
    }

    public boolean areAllJobsStatus(String expectedStatus) {

        By statusElements =
                By.cssSelector("[data-testid^='job-status-']");

        WaitUtils.waitForVisible(
                driver,
                statusElements
        );

        int count =
                driver.findElements(statusElements).size();

        for (int i = 0; i < count; i++) {

            try {

                String actualStatus =
                        driver.findElements(statusElements)
                                .get(i)
                                .getText()
                                .trim();

                if (!actualStatus.equalsIgnoreCase(expectedStatus)) {
                    return false;
                }

            } catch (org.openqa.selenium.StaleElementReferenceException e) {

                i--;
            }
        }

        return true;
    }
    //Pagination
    public void clickNextPage() {

        By nextButton =
                By.cssSelector("[data-testid='pagination-next']");

        WaitUtils.waitForClickable(driver, nextButton);

        click(nextButton);
    }
    public void clickPreviousPage() {

        By previousButton =
                By.cssSelector("[data-testid='pagination-previous']");

        WaitUtils.waitForClickable(driver, previousButton);

        click(previousButton);
    }

    public boolean isPaginationPageActive(int page) {

        By activePage = By.xpath(
                "//li[contains(@class,'active')]" +
                        "//button[text()='" + page + "']"
        );

        try {
            WaitUtils.waitForVisible(
                    driver,
                    activePage
            );

            return true;

        } catch (Exception e) {
            return false;
        }
    }
}