package com.art.tests;

import com.art.driver.Driver;
import com.art.reports.ExtentReport;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class BaseTest {

    @BeforeSuite
    public void beforeSuite() {
        ExtentReport.initReports();
    }

    @BeforeMethod
    protected void setUp() {
        Driver.initDriver();
    }

    @AfterMethod
    protected void tearDown() {
        Driver.quitDriver();
    }

    @AfterSuite
    public void afterSuite() {
        ExtentReport.flushReports();
    }
}
