package com.art.pages;

import org.openqa.selenium.By;

public class LoginPage extends BasePage {
    public LoginPage() {}

    private final By inputUsername = By.cssSelector("input[name='username']");
    private final By inputPassword = By.cssSelector("input[name='password']");
    private final By loginButton = By.cssSelector("button[type='submit']");

    public LoginPage enterUsername() {
        sendKeys(inputUsername, "Admin");
        return this;
    }

    public LoginPage enterPassword() {
        sendKeys(inputPassword, "admin123");
        return this;
    }

    public void clickLoginButton() {
        click(loginButton);
    }
}
