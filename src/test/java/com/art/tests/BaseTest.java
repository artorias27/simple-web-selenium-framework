package com.art.tests;

import com.art.driver.Driver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    @BeforeMethod
    protected void setUp() {
        Driver.initDriver();
    }

    @AfterMethod
    protected void tearDown() {
        Driver.quitDriver();
    }
}
