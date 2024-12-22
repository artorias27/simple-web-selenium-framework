package com.art.driver;

import com.art.constants.FrameworkConstants;
import com.art.utils.PropertyUtils;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
import java.util.Objects;

public final class Driver {
    private Driver() {
    }

    public static void initDriver() throws Exception {
        if (Objects.isNull(DriverManager.getDriver())) {
            System.setProperty("webdriver.chrome.driver", FrameworkConstants.CHROMEDRIVER_PATH);
            DriverManager.setDriver(new ChromeDriver());
            DriverManager.getDriver().get(PropertyUtils.getValue("url"));
            DriverManager.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
        }
    }

    public static void quitDriver() {
        if (Objects.nonNull(DriverManager.getDriver())) {
            DriverManager.getDriver().quit();
            DriverManager.unload();
        }
    }
}
