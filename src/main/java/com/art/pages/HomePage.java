package com.art.pages;

import org.openqa.selenium.By;

public class HomePage extends BasePage {
    private final By title = By.cssSelector(".oxd-topbar-header-title");
    private final By profileDropdownTab = By.cssSelector(".oxd-userdropdown-tab");
    private final By dropDownMenuItems = By.cssSelector(".oxd-userdropdown-link");

    public HomePage clickProfile() {
        click(profileDropdownTab);
        return this;
    }

    public String getPageTitle() {
        return getVisibleText(title);
    }

    public void selectProfileMenu(String menu) {
        clickSpecificElementByText(dropDownMenuItems, menu);
    }
}
