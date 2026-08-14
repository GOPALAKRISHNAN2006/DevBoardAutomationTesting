package com.devboard.listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.devboard.base.BaseTest;
import com.devboard.utils.ExtentReportManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;

public class TestListener implements ITestListener {

    private static ExtentReports extent =
            ExtentReportManager.getReport();

    private static ThreadLocal<ExtentTest> test =
            new ThreadLocal<>();

    @Override
    public void onTestStart(ITestResult result) {

        ExtentTest extentTest =
                extent.createTest(
                        result.getMethod().getMethodName()
                );

        test.set(extentTest);
    }

    @Override
    public void onTestSuccess(ITestResult result) {

        test.get().pass(
                "Test Passed Successfully"
        );
    }

    @Override
    public void onTestFailure(ITestResult result) {

        try {

            test.get().fail(
                    result.getThrowable()
            );

            BaseTest baseTest =
                    (BaseTest) result.getInstance();

            WebDriver driver =
                    baseTest.getDriver();

            TakesScreenshot screenshot =
                    (TakesScreenshot) driver;

            File source =
                    screenshot.getScreenshotAs(
                            OutputType.FILE
                    );

            String testName =
                    result.getMethod().getMethodName();

            File screenshotDir =
                    new File("screenshots");

            if (!screenshotDir.exists()) {
                screenshotDir.mkdirs();
            }

            File destination =
                    new File(
                            screenshotDir,
                            testName +
                                    "_" +
                                    System.currentTimeMillis() +
                                    ".png"
                    );

            FileUtils.copyFile(
                    source,
                    destination
            );

            test.get().fail(
                    "Screenshot",
                    MediaEntityBuilder
                            .createScreenCaptureFromPath(
                                    "../screenshots/" +
                                            destination.getName()
                            )
                            .build()
            );

            System.out.println(
                    "📸 Screenshot saved: " +
                            destination.getAbsolutePath()
            );

        } catch (Exception e) {

            test.get().fail(
                    "Screenshot capture failed: " +
                            e.getMessage()
            );
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {

        test.get().skip(
                "Test Skipped"
        );
    }

    @Override
    public void onFinish(
            org.testng.ITestContext context) {

        extent.flush();

        test.remove();
    }
}