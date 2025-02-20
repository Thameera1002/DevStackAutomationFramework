package com.devstack.automation.testbase;

import com.devstack.automation.utils.PropertyHandler;
import com.devstack.automation.utils.ThreadLocalWebDriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class SeleniumTestBaseHelper {
    protected WebDriver driver;

    @BeforeSuite(alwaysRun = true)
    public void beforeSuite(){
        //extent report init
    }

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod(){
        this.driver = ThreadLocalWebDriverManager.createDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get(PropertyHandler.getProperty("url"));
        // create test for reporting

    }

    @AfterMethod(alwaysRun = true)
    public void afterMethod(){
        ThreadLocalWebDriverManager.removeDriver();
    }

    @AfterSuite(alwaysRun = true)
    public void afterSuite(){
        // flush the report
    }


}
