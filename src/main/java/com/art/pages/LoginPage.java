package com.art.pages;

import com.art.driver.DriverManager;
import org.openqa.selenium.By;

public class LoginPage {
    public LoginPage() {}

    private final By inputUsername = By.cssSelector("input[name='username']");
    private final By inputPassword = By.cssSelector("input[name='password']");
    private final By loginButton = By.cssSelector("button[type='submit']");

    public LoginPage enterUsername() {
        DriverManager.getDriver().findElement(inputUsername).sendKeys("Admin");
        return this;
    }

    public LoginPage enterPassword() {
        DriverManager.getDriver().findElement(inputPassword).sendKeys("admin123");
        return this;
    }

    public void clickLoginButton() {
        DriverManager.getDriver().findElement(loginButton).click();
    }
}
