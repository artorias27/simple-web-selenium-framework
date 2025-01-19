package com.art.tests;

import com.art.pages.HomePage;
import com.art.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class OrangeHRMTests extends BaseTest {
    LoginPage loginPage;
    HomePage homePage;

    @BeforeMethod
    public void beforeMethod() {
        loginPage = new LoginPage();
        homePage = new HomePage();
    }

    @Test(dataProvider = "authDataProvider")
    public void LoginLogoutTest(String username, String password) {
        String pageTitle = "Dashboard";
        loginPage.enterUsername(username).enterPassword(password).clickLoginButton();
        Assert.assertEquals(homePage.getPageTitle(), pageTitle);
        homePage.clickProfile().selectProfileMenu("Support");
        homePage.clickProfile().selectProfileMenu("Logout");
    }

    @Test(dataProvider = "authDataProvider")
    public void NewTest(String username, String password) {
        String pageTitle = "Dashboard";
        loginPage.enterUsername(username).enterPassword(password).clickLoginButton();
        Assert.assertEquals(homePage.getPageTitle(), pageTitle);
        homePage.clickProfile().selectProfileMenu("Support");
        homePage.clickProfile().selectProfileMenu("Logout");
    }

    @DataProvider(name = "authDataProvider", parallel = true)
    public Object[][] getAuthCredentials() {
        return new Object[][] {
                { "Admin", "admin123" },
//                { "Admin", "admin123" },
//                { "Admin", "admin456" },
//                { "Admin", "admin456" },
        };
    }
}
