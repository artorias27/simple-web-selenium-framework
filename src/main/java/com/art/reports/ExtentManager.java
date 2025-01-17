package com.art.reports;

import com.aventstack.extentreports.ExtentTest;

final class ExtentManager {
    private static final ThreadLocal<ExtentTest> testThread = new ThreadLocal<>();

    static ExtentTest getExtentTest() {
        return testThread.get();
    }

    static void setExtentThread(ExtentTest test) {
        testThread.set(test);
    }

    public static void unload() {
        testThread.remove();
    }
}
