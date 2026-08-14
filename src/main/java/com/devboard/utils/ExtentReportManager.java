package com.devboard.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportManager {

    private static ExtentReports extent;

    public static ExtentReports getReport() {

        if (extent == null) {

            ExtentSparkReporter spark =
                    new ExtentSparkReporter(
                            "reports/DevBoard-Automation-Report.html"
                    );

            spark.config().setDocumentTitle(
                    "DevBoard Automation Report"
            );

            spark.config().setReportName(
                    "DevBoard Regression Test Report"
            );

            extent = new ExtentReports();

            extent.attachReporter(spark);

            extent.setSystemInfo(
                    "Application",
                    "DevBoard"
            );

            extent.setSystemInfo(
                    "Framework",
                    "Selenium + TestNG"
            );

            extent.setSystemInfo(
                    "Browser",
                    "Chrome"
            );

            extent.setSystemInfo(
                    "Java",
                    "17"
            );
        }

        return extent;
    }
}