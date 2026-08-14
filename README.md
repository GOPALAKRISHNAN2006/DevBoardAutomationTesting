# DevBoard Automation Testing Suite

A robust, Page Object Model (POM) based end-to-end automation testing framework for the **DevBoard** web application. This framework is designed to validate dev-centric features such as resume building, job tracking, project management, note taking, registration/login flow, and third-party integrations like GitHub and LeetCode.

---

## 🚀 Features & Modules Tested

The automation suite covers complete end-to-end user scenarios and input validation across all key functional areas of DevBoard:

- **Authentication & Security:** 
  - User registration (including existing email and field validation scenarios).
  - Secure login, session persistence, and logout flow.
  - Protected route redirection checks.
- **Resume Builder:**
  - Automated summary editing, adding/updating work experience, education, and certifications.
  - Verification of resume preview.
- **Job Tracker:**
  - Operations for adding, editing, searching, pagination, filtering, and deleting job postings.
  - Form validation with DataProvider integration.
- **Project Board:**
  - Operations for creating, updating, deleting, searching, filtering, and pagination of user projects.
- **Developer Profiles:**
  - Custom profiles updates, persistence validation, and integration verification for GitHub and LeetCode.
- **Notes Application:**
  - Pinned notes, archived notes, note editing, boundary condition handling, search, and validation.

---

## 🛠️ Technology Stack

- **Language:** Java 17
- **Browser Automation:** Selenium WebDriver (v4.35.0)
- **Test Runner:** TestNG (v7.11.0)
- **Build & Dependency Management:** Maven
- **Reporting:** Extent Reports (v5.1.2)
- **WebDriver Management:** WebDriverManager (v6.3.2)

---

## 📁 Project Structure

```
DevBoardAutomation/
├── src/
│   ├── main/
│   │   ├── java/com/devboard/
│   │   │   ├── config/       # Configurations (ConfigReader)
│   │   │   ├── pages/        # Page Object Model (POM) Pages
│   │   │   └── utils/        # ExtentReportManager, DriverFactory, WaitUtils
│   │   └── resources/        # config.properties
│   └── test/
│       └── java/
│           ├── com/devboard/
│           │   ├── base/      # BaseTest (Setup and teardown of WebDriver)
│           │   ├── listeners/ # TestListener for capturing screenshots/reports
│           │   └── tests/     # Module-specific Test Cases
│           └── testdata/      # Test data suppliers / classes
├── testing.xml                # TestNG suite suite definition file
├── pom.xml                    # Maven dependencies and plugin execution info
└── README.md                  # Project Documentation (this file)
```

---

## ⚙️ Configuration & Setup

### Prerequisites
Make sure you have the following installed:
1. **Java JDK 17**
2. **Apache Maven 3.8+**
3. **Google Chrome** browser (WebDriverManager handles matching driver version automatically)

### Local Configuration
Update properties inside `src/main/resources/config.properties` to adjust target environments:
```properties
baseUrl=http://localhost:5173
browser=chrome
timeout=10
```

---

## 🏃 Run Instructions

Run all test suites configured in `testing.xml` using Maven:

```bash
mvn clean test
```

To run a specific test suite or class:
```bash
mvn test -Dtest=EndToEndTest
```

---

## 📊 Extent Reports & Logging

This framework is equipped with **Extent Reports** integration to generate rich visual reports upon test execution:
- Reports containing execution duration, pass/fail status, and stack traces on failures.
- Reports are saved inside the `reports/` folder automatically.
