package com.devboard.pages;

import com.devboard.base.BasePage;
import com.devboard.utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ProjectPage extends BasePage {
    public ProjectPage(WebDriver driver){
        super(driver);
    }
    // Buttons
    private By addProjectButton =
            By.cssSelector("[data-testid='add-project-button']");
    private By saveProjectButton =
            By.cssSelector("[data-testid='save-project-button']");
    // Inputs
    private By titleInput =
            By.cssSelector("[data-testid='project-title-input']");

    private By descriptionInput =
            By.cssSelector("[data-testid='project-description-input']");

    private By techStackInput =
            By.cssSelector("[data-testid='project-techstack-input']");

    private By githubInput =
            By.cssSelector("[data-testid='project-github-input']");

    private By liveUrlInput =
            By.cssSelector("[data-testid='project-liveurl-input']");

    // Dropdown
    private By statusDropdown =
            By.cssSelector("[data-testid='project-status-select']");

    private By searchInput =
            By.cssSelector("[data-testid='projects-search-input']");

    //Methods
    public void searchProject(String projectName) {
        WaitUtils.waitForVisible(driver, searchInput);
        type(searchInput, projectName);
    }

    public void clickAddProject() {
        WaitUtils.waitForVisible(driver, addProjectButton);
        click(addProjectButton);
    }

    public void enterTitle(String title) {
        WaitUtils.waitForVisible(driver, titleInput);
        type(titleInput, title);
    }

    public void enterDescription(String description) {
        type(descriptionInput, description);
    }

    public void enterTechStack(String techStack) {
        type(techStackInput, techStack);
    }

    public void enterGithub(String github) {
        type(githubInput, github);
    }

    public void enterLiveUrl(String liveUrl) {
        type(liveUrlInput, liveUrl);
    }

    public void selectStatus(String status) {
        Select select = new Select(driver.findElement(statusDropdown));
        select.selectByVisibleText(status);
    }

    public void clickSave() {
        click(saveProjectButton);
        WaitUtils.waitForInvisible(driver, saveProjectButton);
    }

    public void clickSaveWithoutWaiting() {
        click(saveProjectButton);
    }

    public void addProject(String title,String description,String techstack,
                           String github,String liveUrl,String status){
        clickAddProject();
        enterTitle(title);
        enterDescription(description);
        enterTechStack(techstack);
        enterGithub(github);
        enterLiveUrl(liveUrl);
        selectStatus(status);
        clickSave();
    }

    public boolean isProjectPresent(String projectName) {
        By locator =
                By.xpath("//h5[contains(text(),'" + projectName + "')]");
        try{
            WaitUtils.waitForVisible(driver, locator);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isProjectFormDisplayed() {

        return isDisplayed(
                By.cssSelector("[data-testid='project-form']")
        );
    }

//---------------------- Edit------------------------
    public void clickEditProject(String projectName) {
        By editButton = By.xpath(
                "//h5[contains(text(),'" + projectName + "')]" +
                        "/ancestor::div[contains(@class,'project-card')]" +
                        "//button[1]"
        );
        click(editButton);
    }

    public void updateTitle(String newTitle) {
        type(titleInput, newTitle);
    }

    public void editProject(String oldTitle, String newTitle) {
        clickEditProject(oldTitle);
        updateTitle(newTitle);
        clickSave();

        isProjectPresent(newTitle);
    }



  //---------------- Without Title-----------------------
    public void addProjectWithoutTitle(
            String description,
            String techStack,
            String github,
            String liveUrl,
            String status) {
        clickAddProject();
        enterDescription(description);
        enterTechStack(techStack);
        enterGithub(github);
        enterLiveUrl(liveUrl);
        selectStatus(status);
        clickSaveWithoutWaiting();
    }





    public boolean isTitleInvalid() {

        WebElement title =
                driver.findElement(titleInput);

        return !title.getAttribute("validationMessage").isEmpty();
    }

 // -------------------------Without Description------------------------

    public void addProjectWithoutDescription(
            String title,
            String techStack,
            String github,
            String liveUrl,
            String status) {

        clickAddProject();

        enterTitle(title);

        // Description intentionally left empty

        enterTechStack(techStack);
        enterGithub(github);
        enterLiveUrl(liveUrl);
        selectStatus(status);

        clickSaveWithoutWaiting();
    }
    public boolean isDescriptionInvalid() {

        WebElement description =
                driver.findElement(descriptionInput);

        return !description
                .getAttribute("validationMessage")
                .isEmpty();
    }

    //-------------------- Delete Project ------------------
    private By confirmDeleteButton =
            By.cssSelector("[data-testid='delete-project-button']");

    public void clickDeleteProject(String projectName) {
        By deleteButton = By.xpath(
                "//h5[contains(text(),'" + projectName + "')]" +
                        "/ancestor::div[contains(@class,'project-card')]" +
                        "//button[2]"
        );
        WaitUtils.waitForVisible(driver, deleteButton);
        click(deleteButton);
    }

    public void confirmDelete() {
        WaitUtils.waitForVisible(driver, confirmDeleteButton);
        click(confirmDeleteButton);
    }

    public void deleteProject(String projectName) {
        clickDeleteProject(projectName);
        confirmDelete();
    }

    public boolean isProjectDeleted(String projectName) {

        By locator =
                By.xpath("//h5[contains(text(),'" + projectName + "')]");
        return WaitUtils.waitForElementToDisappear(driver, locator);
    }
    // --------------------------Filter Project Status------------------------------------

    public void filterByStatus(String status) {
        By statusFilter =
                By.cssSelector("[data-testid='projects-status-filter']");
        WaitUtils.waitForVisible(driver, statusFilter);

        Select select =
                new Select(driver.findElement(statusFilter));

        select.selectByVisibleText(status);
    }
    public String getSelectedStatusFilter() {

        By statusFilter =
                By.cssSelector("[data-testid='projects-status-filter']");

        Select select =
                new Select(driver.findElement(statusFilter));

        return select.getFirstSelectedOption().getText();
    }

    //------------------Pagination--------------------

    public void clickPage(int pageNumber) {

        By pageButton =
                By.cssSelector(
                        "[data-testid='pagination-page-" + pageNumber + "']"
                );
        WaitUtils.waitForVisible(driver, pageButton);
        click(pageButton);
    }

    public String getCurrentPage() {

        By activePage =
                By.cssSelector(".page-item.active .page-link");

        WaitUtils.waitForVisible(driver, activePage);

        return getText(activePage);
    }

}

