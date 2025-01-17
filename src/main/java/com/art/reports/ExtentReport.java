package com.art.reports;

import com.art.constants.FrameworkConstants;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

public final class ExtentReport {
    private static ExtentReports extent;

    public static void initReports() {
        if (Objects.isNull(extent)) {
            extent = new ExtentReports();
            ExtentSparkReporter sparkReporter = new ExtentSparkReporter(FrameworkConstants.EXTENT_REPORT_PATH);
            extent.attachReporter(sparkReporter);
            sparkReporter.config().setTheme(Theme.DARK);
            sparkReporter.config().setDocumentTitle("Automation Test Report");
            sparkReporter.config().setReportName("Automation Report");
        }
    }

    public static void flushReports() throws IOException {
        if (Objects.nonNull(extent)) {
            extent.flush();
        }
        Desktop.getDesktop().browse(new File(FrameworkConstants.EXTENT_REPORT_PATH).toURI());
        ExtentManager.unload();
    }

    public static void createTest(String testCaseName) {
        ExtentManager.setExtentThread(extent.createTest(testCaseName));
    }
}
