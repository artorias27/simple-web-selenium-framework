package com.art.pages;

import com.art.reports.ExtentManager;
import org.openqa.selenium.By;

public class LoginPage extends BasePage {
    public LoginPage() {}

    private final By inputUsername = By.cssSelector("input[name='username']");
    private final By inputPassword = By.cssSelector("input[name='password']");
    private final By loginButton = By.cssSelector("button[type='submit']");

    public LoginPage enterUsername(String username) {
        sendKeys(inputUsername, username);
        ExtentManager.getExtentTest().pass("Enter username");
        return this;
    }

    public LoginPage enterPassword(String password) {
        sendKeys(inputPassword, password);
        ExtentManager.getExtentTest().pass("Enter password");
        return this;
    }

    public void clickLoginButton() {
        click(loginButton);
    }
}
