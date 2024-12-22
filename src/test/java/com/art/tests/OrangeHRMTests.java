package com.art.tests;

import com.art.pages.HomePage;
import com.art.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class OrangeHRMTests extends BaseTest {
    LoginPage loginPage;
    HomePage homePage;

    @BeforeMethod
    public void beforeMethod() {
        loginPage = new LoginPage();
        homePage = new HomePage();
    }

    @Test
    public void LoginLogoutTest() {
        String pageTitle = "Dashboard";
        loginPage.enterUsername().enterPassword().clickLoginButton();
        Assert.assertEquals(homePage.getPageTitle(), pageTitle);
        homePage.clickProfile().clickLogout();
    }
}
