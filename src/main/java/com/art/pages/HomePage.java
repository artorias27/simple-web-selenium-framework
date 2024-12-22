package com.art.pages;

import com.art.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;
import java.util.Objects;

public class HomePage {
    private final By title = By.cssSelector(".oxd-topbar-header-title");
    private final By profileDropdownTab = By.cssSelector(".oxd-userdropdown-tab");
    private final By dropDownMenuItems = By.cssSelector(".oxd-userdropdown-link");

    public HomePage clickProfile() {
        DriverManager.getDriver().findElement(profileDropdownTab).click();
        return this;
    }

    public String getPageTitle() {
        return DriverManager.getDriver().findElement(title).getText();
    }

    public void clickLogout() {
        List<WebElement> menuItems = DriverManager.getDriver().findElements(dropDownMenuItems);
        WebElement logoutButton = menuItems.stream().filter(menuElement -> Objects.equals(menuElement.getAttribute("text"), "Logout"))
                                                    .toList().get(0);
        logoutButton.click();
    }
}
