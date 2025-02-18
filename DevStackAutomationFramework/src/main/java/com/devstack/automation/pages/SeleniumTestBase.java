package com.devstack.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SeleniumTestBase {

    protected WebDriver driver;

    public SeleniumTestBase(WebDriver driver) {
        this.driver = driver;
    }


    public void click(By locator) {
        WebElement element = driver.findElement(locator);
        element.click();
    }

    public void type(By locator,String inputText) {
        WebElement element = driver.findElement(locator);
        element.click();
        element.clear();
        element.sendKeys(inputText);
    }
}
