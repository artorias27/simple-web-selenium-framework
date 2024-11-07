package com.art.driver;

import com.art.constants.FrameworkConstants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Objects;

public class Driver {
    public static WebDriver driver;
    private static ThreadLocal<WebDriver> driverThread = new ThreadLocal<>();

    public static WebDriver getDriver() {
        return driverThread.get();
    }

    public static void setDriver(WebDriver dr) {
        driverThread.set(dr);
    }

    public static void unload() {
        driverThread.remove();
    }

    public static void initDriver() {
        if (Objects.isNull(getDriver())) {
            System.setProperty("webdriver.chrome.driver", FrameworkConstants.getChromedriverPath());
            driver = new ChromeDriver();
            setDriver(driver);
            getDriver().get("https://google.com");
        }
    }

    public static void quitDriver() {
        if (Objects.nonNull(driver)) {
            getDriver().quit();
            setDriver(null);
        }
    }
}
