package com.art.pages;

import com.art.constants.FrameworkConstants;
import com.art.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;
import java.util.Objects;

public class BasePage {
    protected void click(By by) {
        waitForElementToBeClickable(by).click();
    }

    protected void clickSpecificElementByText(By by, String textValue) {
        waitForElementToBePresent(by);
        List<WebElement> elements = DriverManager.getDriver().findElements(by);
        WebElement foundElement = elements.stream().filter(element -> Objects.equals(element.getAttribute("text"), textValue))
                .toList().get(0);
        foundElement.click();
    }

    protected void sendKeys(By by, String value) {
        waitForElementToBePresent(by).sendKeys(value);
    }

//    protected String getAttributeText(By by) {
//        waitForElementToBePresent(by);
//        return DriverManager.getDriver().findElement(by).getAttribute("text");
//    }

    protected String getInnerText(By by) {
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
