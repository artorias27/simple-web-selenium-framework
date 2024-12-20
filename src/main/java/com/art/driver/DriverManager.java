package com.art.driver;

import org.openqa.selenium.WebDriver;

public final class DriverManager {
    private DriverManager() {

    }

    private static final ThreadLocal<WebDriver> threadDriver = new ThreadLocal<>();

    public static WebDriver getDriver() {
        return threadDriver.get();
    }

    public static void setDriver(WebDriver driver) {
        threadDriver.set(driver);
    }

    public static void unload() {
        threadDriver.remove();
    }
}
