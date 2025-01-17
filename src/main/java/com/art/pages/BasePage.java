package com.art.pages;

import com.art.constants.FrameworkConstants;
import com.art.driver.DriverManager;
import com.art.reports.ExtentLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;
import java.util.Objects;

public class BasePage {
    protected void click(By by, String msg) {
        waitForElementToBeClickable(by).click();
        ExtentLogger.info("Clicked " + msg);
    }

    protected void clickSpecificElementByText(By by, String textValue) {
        waitForElementToBePresent(by);
        List<WebElement> elements = DriverManager.getDriver().findElements(by);
        WebElement foundElement = elements.stream().filter(element -> Objects.equals(element.getDomProperty("text"), textValue))
                .toList().get(0);
        foundElement.click();
    }

    protected void sendKeys(By by, String value, String msg) {
        waitForElementToBePresent(by).sendKeys(value);
        ExtentLogger.info(msg + " : " + value);
    }

    protected String getVisibleText(By by) {
        return waitForElementToBePresent(by).getText();
    }

    protected WebElement waitForElementToBeClickable(By by) {
        return new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(FrameworkConstants.WAIT_TIME))
                .until(ExpectedConditions.elementToBeClickable(by));
    }

    protected WebElement waitForElementToBePresent(By by) {
        return new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(FrameworkConstants.WAIT_TIME))
                .until(ExpectedConditions.presenceOfElementLocated(by));
    }
}
