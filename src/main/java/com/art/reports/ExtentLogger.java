package com.art.reports;

import com.art.driver.DriverManager;
import com.art.utils.PropertyUtils;
import com.aventstack.extentreports.MediaEntityBuilder;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public final class ExtentLogger {
    public static void pass(String message) {
        if (PropertyUtils.getValue("passedStepScreenshot").equalsIgnoreCase("yes")) {
            ExtentManager.getExtentTest().pass(message, MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64Image()).build());
            return;
        }
        ExtentManager.getExtentTest().pass(message);

    }

    public static void fail(String message) {
        if (PropertyUtils.getValue("failedStepScreenshot").equalsIgnoreCase("yes")) {
            ExtentManager.getExtentTest().fail(message, MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64Image()).build());
            return;
        }
        ExtentManager.getExtentTest().fail(message);
    }

    public static void fail(String message, Boolean attachScreenshot) {
        if (attachScreenshot) {
            ExtentManager.getExtentTest().fail(message, MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64Image()).build());
            return;
        }
        ExtentManager.getExtentTest().fail(message);
    }

    public static void skip(String message) {
        if (PropertyUtils.getValue("skippedStepScreenshot").equalsIgnoreCase("yes")) {
            ExtentManager.getExtentTest().skip(message, MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64Image()).build());
            return;
        }
        ExtentManager.getExtentTest().skip(message);
    }

    public static void info(String message) {
        ExtentManager.getExtentTest().info(message);
    }

    public static String getBase64Image() {
        return ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BASE64);
    }
}
