package com.art.reports;

import com.aventstack.extentreports.ExtentTest;

public final class ExtentManager {
    private static final ThreadLocal<ExtentTest> testThread = new ThreadLocal<>();

    public static ExtentTest getExtentTest() {
        return testThread.get();
    }

    public static void setExtentThread(ExtentTest test) {
        testThread.set(test);
    }

    public static void unload() {
        testThread.remove();
    }
}
