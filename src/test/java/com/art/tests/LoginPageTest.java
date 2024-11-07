package com.art.tests;

import com.art.driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseTest {
    @Test
    public void test1() {
        Driver.driver.findElement(By.name("q")).sendKeys("Automation", Keys.ENTER);
    }
}
