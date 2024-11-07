package com.art.tests;

import com.art.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseTest {
    @Test
    public void test1() {
        DriverManager.getDriver().findElement(By.name("q")).sendKeys("Automation", Keys.ENTER);
    }

    @Test
    public void test2() {
        DriverManager.getDriver().findElement(By.name("q")).sendKeys("Automation2", Keys.ENTER);
    }
}
