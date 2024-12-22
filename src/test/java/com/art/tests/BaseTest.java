package com.art.tests;

import com.art.driver.Driver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {

    @BeforeClass
    protected void setUp() throws Exception {
        Driver.initDriver();
    }

    @AfterClass
    protected void tearDown() {
        Driver.quitDriver();
    }
}
