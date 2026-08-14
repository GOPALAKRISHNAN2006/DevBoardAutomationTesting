package com.devboard.tests.Resume;

import com.devboard.base.BaseTest;
import com.devboard.config.ConfigReader;
import com.devboard.pages.DashboardPage;
import com.devboard.pages.LoginPage;
import com.devboard.pages.ResumePage;
import com.devboard.utils.WaitUtils;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ResumeValidationDataProviderTest extends BaseTest {

    @DataProvider(name = "experienceValidationData")
    public Object[][] experienceValidationData() {
        return new Object[][]{
                {"", "Google", true, false, "empty role"},
                {"Software Engineer", "", false, true, "empty company"},
                {"", "", true, true, "empty role and company"}
        };
    }

    @Test(dataProvider = "experienceValidationData")
    public void experienceValidationTest(
            String role,
            String company,
            boolean roleInvalid,
            boolean companyInvalid,
            String scenario
    ) {

        driver.get(
                ConfigReader.getProperty("baseUrl") + "/login"
        );

        LoginPage loginPage =
                new LoginPage(driver);

        loginPage.login(
                "gopalmuruga001@gmail.com",
                "1234567890"
        );

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

        driver.get(
                ConfigReader.getProperty("baseUrl") + "/resume"
        );

        WaitUtils.waitForUrl(
                driver,
                "/resume"
        );

        ResumePage resumePage =
                new ResumePage(driver);

        Assert.assertTrue(
                resumePage.isResumePageLoaded(),
                "Resume page was not loaded."
        );

        resumePage.clickAddExperience();

        resumePage.enterExperienceRole(role);

        resumePage.enterExperienceCompany(company);

        resumePage.clickSaveExperience();

        if (roleInvalid) {
            Assert.assertTrue(
                    resumePage.isExperienceRoleInvalid(),
                    "Role validation was not triggered for: "
                            + scenario
            );
        }

        if (companyInvalid) {
            Assert.assertTrue(
                    resumePage.isExperienceCompanyInvalid(),
                    "Company validation was not triggered for: "
                            + scenario
            );
        }

        System.out.println(
                "✅ Experience " + scenario + " validation passed"
        );
    }

    @DataProvider(name = "educationValidationData")
    public Object[][] educationValidationData() {
        return new Object[][]{
                {"", "SIET", true, false, "empty degree"},
                {"B.Tech IT", "", false, true, "empty institution"},
                {"", "", true, true, "empty degree and institution"}
        };
    }

    @Test(dataProvider = "educationValidationData")
    public void educationValidationTest(
            String degree,
            String institute,
            boolean degreeInvalid,
            boolean instituteInvalid,
            String scenario
    ) {

        driver.get(
                ConfigReader.getProperty("baseUrl") + "/login"
        );

        LoginPage loginPage =
                new LoginPage(driver);

        loginPage.login(
                "gopalmuruga001@gmail.com",
                "1234567890"
        );

        WaitUtils.waitForUrl(
                driver,
                "/dashboard"
        );

        driver.get(
                ConfigReader.getProperty("baseUrl") + "/resume"
        );

        WaitUtils.waitForUrl(
                driver,
                "/resume"
        );

        ResumePage resumePage =
                new ResumePage(driver);

        resumePage.clickAddEducation();

        resumePage.enterEducationDegree(degree);

        resumePage.enterEducationInstitute(institute);

        resumePage.clickSaveEducation();

        if (degreeInvalid) {
            Assert.assertTrue(
                    resumePage.isEducationDegreeInvalid(),
                    "Degree validation was not triggered for: "
                            + scenario
            );
        }

        if (instituteInvalid) {
            Assert.assertTrue(
                    resumePage.isEducationInstituteInvalid(),
                    "Institution validation was not triggered for: "
                            + scenario
            );
        }

        System.out.println(
                "✅ Education " + scenario + " validation passed"
        );
    }

    @DataProvider(name = "certificationValidationData")
    public Object[][] certificationValidationData() {
        return new Object[][]{
                {"", "AWS", true, false, "empty title"},
                {"AWS Developer", "", false, true, "empty issuer"},
                {"", "", true, true, "empty title and issuer"}
        };
    }

    @Test(dataProvider = "certificationValidationData")
    public void certificationValidationTest(
            String title,
            String issuer,
            boolean titleInvalid,
            boolean issuerInvalid,
            String scenario
    ) {

        driver.get(
                ConfigReader.getProperty("baseUrl") + "/login"
        );

        LoginPage loginPage =
                new LoginPage(driver);

        loginPage.login(
                "gopalmuruga001@gmail.com",
                "1234567890"
        );

        WaitUtils.waitForUrl(
                driver,
                "/dashboard"
        );

        driver.get(
                ConfigReader.getProperty("baseUrl") + "/resume"
        );

        WaitUtils.waitForUrl(
                driver,
                "/resume"
        );

        ResumePage resumePage =
                new ResumePage(driver);

        resumePage.clickAddCertification();

        resumePage.enterCertificationTitle(title);

        resumePage.enterCertificationIssuer(issuer);

        resumePage.clickSaveCertification();

        if (titleInvalid) {
            Assert.assertTrue(
                    resumePage.isCertificationTitleInvalid(),
                    "Certification title validation was not triggered for: "
                            + scenario
            );
        }

        if (issuerInvalid) {
            Assert.assertTrue(
                    resumePage.isCertificationIssuerInvalid(),
                    "Certification issuer validation was not triggered for: "
                            + scenario
            );
        }

        System.out.println(
                "✅ Certification " + scenario + " validation passed"
        );
    }
}