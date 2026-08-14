package com.devboard.pages;

import com.devboard.base.BasePage;
import com.devboard.utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ResumePage extends BasePage {

    public ResumePage(WebDriver driver) {
        super(driver);
    }

    // =========================================================
    // PAGE
    // =========================================================

    private By pageTitle =
            By.cssSelector("[data-testid='resume-page-title']");


    // =========================================================
    // HEADER ACTIONS
    // =========================================================

    private By previewButton =
            By.cssSelector("[data-testid='resume-preview-button']");

    private By downloadButton =
            By.cssSelector("[data-testid='resume-download-button']");


    // =========================================================
    // READINESS
    // =========================================================

    private By readinessSection =
            By.cssSelector("[data-testid='resume-readiness-section']");

    private By completionScore =
            By.cssSelector("[data-testid='resume-completion-score']");

    private By polishButton =
            By.cssSelector("[data-testid='resume-polish-button']");


    // =========================================================
    // SUMMARY
    // =========================================================

    private By summarySection =
            By.cssSelector("[data-testid='resume-summary-section']");

    private By headline =
            By.cssSelector("[data-testid='resume-headline']");

    private By summaryText =
            By.cssSelector("[data-testid='resume-summary-text']");

    private By skillsList =
            By.cssSelector("[data-testid='resume-skills-list']");

    private By editSummaryButton =
            By.cssSelector("[data-testid='resume-edit-summary-button']");


    // =========================================================
    // EXPERIENCE
    // =========================================================

    private By experienceSection =
            By.cssSelector("[data-testid='resume-experience-section']");

    private By addExperienceButton =
            By.cssSelector("[data-testid='resume-add-experience-button']");

    private By experienceRoleInput =
            By.cssSelector("[data-testid='resume-experience-role-input']");

    private By experienceCompanyInput =
            By.cssSelector("[data-testid='resume-experience-company-input']");

    private By experienceDurationInput =
            By.cssSelector("[data-testid='resume-experience-duration-input']");

    private By experienceDescriptionInput =
            By.cssSelector("[data-testid='resume-experience-description-input']");

    private By experienceSaveButton =
            By.cssSelector("[data-testid='resume-experience-save-button']");


    // =========================================================
    // EDUCATION
    // =========================================================

    private By educationSection =
            By.cssSelector("[data-testid='resume-education-section']");

    private By addEducationButton =
            By.cssSelector("[data-testid='resume-add-education-button']");

    private By educationDegreeInput =
            By.cssSelector("[data-testid='resume-education-degree-input']");

    private By educationInstituteInput =
            By.cssSelector("[data-testid='resume-education-institute-input']");

    private By educationYearInput =
            By.cssSelector("[data-testid='resume-education-year-input']");

    private By educationCgpaInput =
            By.cssSelector("[data-testid='resume-education-cgpa-input']");

    private By educationSaveButton =
            By.cssSelector("[data-testid='resume-education-save-button']");


    // =========================================================
    // CERTIFICATION
    // =========================================================

    private By certificationSection =
            By.cssSelector("[data-testid='resume-certifications-section']");

    private By addCertificationButton =
            By.cssSelector("[data-testid='resume-add-certification-button']");

    private By certificationTitleInput =
            By.cssSelector("[data-testid='resume-certification-title-input']");

    private By certificationIssuerInput =
            By.cssSelector("[data-testid='resume-certification-issuer-input']");

    private By certificationYearInput =
            By.cssSelector("[data-testid='resume-certification-year-input']");

    private By certificationSaveButton =
            By.cssSelector("[data-testid='resume-certification-save-button']");


    // =========================================================
    // PREVIEW
    // =========================================================

    private By previewTitle =
            By.cssSelector("[data-testid='resume-preview-title']");

    private By previewContent =
            By.cssSelector("[data-testid='resume-preview-content']");

    private By previewDownloadButton =
            By.cssSelector("[data-testid='resume-preview-download-button']");


    // =========================================================
    // PAGE METHODS
    // =========================================================

    public boolean isResumePageLoaded() {

        WaitUtils.waitForVisible(
                driver,
                pageTitle
        );

        return driver.getCurrentUrl()
                .contains("/resume");
    }


    // =========================================================
    // HEADER
    // =========================================================

    public boolean isPreviewButtonDisplayed() {

        WaitUtils.waitForVisible(
                driver,
                previewButton
        );

        return driver.findElement(previewButton)
                .isDisplayed();
    }

    public boolean isDownloadButtonDisplayed() {

        WaitUtils.waitForVisible(
                driver,
                downloadButton
        );

        return driver.findElement(downloadButton)
                .isDisplayed();
    }


    public void clickPreview() {

        WaitUtils.waitForClickable(
                driver,
                previewButton
        );

        click(previewButton);
    }


    public void clickDownload() {

        WaitUtils.waitForClickable(
                driver,
                downloadButton
        );

        click(downloadButton);
    }


    // =========================================================
    // READINESS
    // =========================================================

    public boolean isReadinessSectionDisplayed() {

        WaitUtils.waitForVisible(
                driver,
                readinessSection
        );

        return driver.findElement(readinessSection)
                .isDisplayed();
    }


    public boolean isCompletionScoreDisplayed() {

        WaitUtils.waitForVisible(
                driver,
                completionScore
        );

        return driver.findElement(completionScore)
                .isDisplayed();
    }


    // =========================================================
    // SUMMARY
    // =========================================================

    public boolean isSummarySectionDisplayed() {

        WaitUtils.waitForVisible(
                driver,
                summarySection
        );

        return driver.findElement(summarySection)
                .isDisplayed();
    }


    public boolean isHeadlineDisplayed() {

        WaitUtils.waitForVisible(
                driver,
                headline
        );

        return driver.findElement(headline)
                .isDisplayed();
    }


    public boolean isSummaryDisplayed() {

        WaitUtils.waitForVisible(
                driver,
                summaryText
        );

        return driver.findElement(summaryText)
                .isDisplayed();
    }


    public boolean isSkillsDisplayed() {

        WaitUtils.waitForVisible(
                driver,
                skillsList
        );

        return driver.findElement(skillsList)
                .isDisplayed();
    }


    public void clickEditSummary() {

        WaitUtils.waitForClickable(
                driver,
                editSummaryButton
        );

        click(editSummaryButton);
    }


    // =========================================================
    // SUMMARY FORM
    // =========================================================

    public void enterHeadline(String value) {

        WaitUtils.waitForVisible(
                driver,
                By.cssSelector(
                        "[data-testid='resume-headline-input']"
                )
        );

        driver.findElement(
                By.cssSelector(
                        "[data-testid='resume-headline-input']"
                )
        ).clear();

        driver.findElement(
                By.cssSelector(
                        "[data-testid='resume-headline-input']"
                )
        ).sendKeys(value);
    }


    public void enterSummary(String value) {

        By locator =
                By.cssSelector(
                        "[data-testid='resume-summary-input']"
                );

        WaitUtils.waitForVisible(
                driver,
                locator
        );

        driver.findElement(locator)
                .clear();

        driver.findElement(locator)
                .sendKeys(value);
    }


    public void enterSkills(String value) {

        By locator =
                By.cssSelector(
                        "[data-testid='resume-skills-input']"
                );

        WaitUtils.waitForVisible(
                driver,
                locator
        );

        driver.findElement(locator)
                .clear();

        driver.findElement(locator)
                .sendKeys(value);
    }


    public void clickSaveSummary() {

        By locator =
                By.cssSelector(
                        "[data-testid='resume-summary-save-button']"
                );

        WaitUtils.waitForClickable(
                driver,
                locator
        );

        click(locator);
    }


    // =========================================================
    // EXPERIENCE
    // =========================================================

    public boolean isExperienceSectionDisplayed() {

        WaitUtils.waitForVisible(
                driver,
                experienceSection
        );

        return driver.findElement(experienceSection)
                .isDisplayed();
    }


    public void clickAddExperience() {

        WaitUtils.waitForClickable(
                driver,
                addExperienceButton
        );

        click(addExperienceButton);
    }


    public void enterExperienceRole(String value) {

        fillField(
                experienceRoleInput,
                value
        );
    }


    public void enterExperienceCompany(String value) {

        fillField(
                experienceCompanyInput,
                value
        );
    }


    public void enterExperienceDuration(String value) {

        fillField(
                experienceDurationInput,
                value
        );
    }


    public void enterExperienceDescription(String value) {

        fillField(
                experienceDescriptionInput,
                value
        );
    }


    public void clickSaveExperience() {

        WaitUtils.waitForClickable(
                driver,
                experienceSaveButton
        );

        click(experienceSaveButton);
    }


    // =========================================================
    // EDUCATION
    // =========================================================

    public boolean isEducationSectionDisplayed() {

        WaitUtils.waitForVisible(
                driver,
                educationSection
        );

        return driver.findElement(educationSection)
                .isDisplayed();
    }


    public void clickAddEducation() {

        WaitUtils.waitForClickable(
                driver,
                addEducationButton
        );

        click(addEducationButton);
    }


    public void enterEducationDegree(String value) {

        fillField(
                educationDegreeInput,
                value
        );
    }


    public void enterEducationInstitute(String value) {

        fillField(
                educationInstituteInput,
                value
        );
    }


    public void enterEducationYear(String value) {

        fillField(
                educationYearInput,
                value
        );
    }


    public void enterEducationCgpa(String value) {

        fillField(
                educationCgpaInput,
                value
        );
    }


    public void clickSaveEducation() {

        WaitUtils.waitForClickable(
                driver,
                educationSaveButton
        );

        click(educationSaveButton);
    }


    // =========================================================
    // CERTIFICATION
    // =========================================================

    public boolean isCertificationSectionDisplayed() {

        WaitUtils.waitForVisible(
                driver,
                certificationSection
        );

        return driver.findElement(certificationSection)
                .isDisplayed();
    }


    public void clickAddCertification() {

        WaitUtils.waitForClickable(
                driver,
                addCertificationButton
        );

        click(addCertificationButton);
    }


    public void enterCertificationTitle(String value) {

        fillField(
                certificationTitleInput,
                value
        );
    }


    public void enterCertificationIssuer(String value) {

        fillField(
                certificationIssuerInput,
                value
        );
    }


    public void enterCertificationYear(String value) {

        fillField(
                certificationYearInput,
                value
        );
    }


    public void clickSaveCertification() {

        WaitUtils.waitForClickable(
                driver,
                certificationSaveButton
        );

        click(certificationSaveButton);
    }


    // =========================================================
    // PREVIEW
    // =========================================================

    public boolean isPreviewDisplayed() {

        WaitUtils.waitForVisible(
                driver,
                previewContent
        );

        return driver.findElement(previewContent)
                .isDisplayed();
    }


    public boolean isPreviewTitleDisplayed() {

        WaitUtils.waitForVisible(
                driver,
                previewTitle
        );

        return driver.findElement(previewTitle)
                .isDisplayed();
    }


    public void clickPreviewDownload() {

        WaitUtils.waitForClickable(
                driver,
                previewDownloadButton
        );

        click(previewDownloadButton);
    }


    // =========================================================
    // COMMON FIELD METHOD
    // =========================================================

    private void fillField(
            By locator,
            String value
    ) {

        WaitUtils.waitForVisible(
                driver,
                locator
        );

        driver.findElement(locator)
                .clear();

        driver.findElement(locator)
                .sendKeys(value);
    }
    public boolean isExperienceRoleInvalid() {
        return !driver.findElement(experienceRoleInput)
                .getAttribute("validationMessage")
                .isEmpty();
    }

    public boolean isExperienceCompanyInvalid() {
        return !driver.findElement(experienceCompanyInput)
                .getAttribute("validationMessage")
                .isEmpty();
    }

    public boolean isEducationDegreeInvalid() {
        return !driver.findElement(educationDegreeInput)
                .getAttribute("validationMessage")
                .isEmpty();
    }

    public boolean isEducationInstituteInvalid() {
        return !driver.findElement(educationInstituteInput)
                .getAttribute("validationMessage")
                .isEmpty();
    }

    public boolean isCertificationTitleInvalid() {
        return !driver.findElement(certificationTitleInput)
                .getAttribute("validationMessage")
                .isEmpty();
    }

    public boolean isCertificationIssuerInvalid() {
        return !driver.findElement(certificationIssuerInput)
                .getAttribute("validationMessage")
                .isEmpty();
    }
}