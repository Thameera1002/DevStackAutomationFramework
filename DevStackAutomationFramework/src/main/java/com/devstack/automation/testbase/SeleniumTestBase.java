package com.devstack.automation.testbase;

import com.devstack.automation.utils.ThreadLocalWebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SeleniumTestBase {

    protected static WebDriver driver;

    public SeleniumTestBase(WebDriver driver) {
        this.driver = ThreadLocalWebDriverManager.getDriver();
    }


    public void click(By locator) {
        WebElement element = waitForVisibilityOfElement(driver.findElement(locator));
        moveToElement(element);
        element.click();
    }

    public void type(By locator,String inputText) {
        WebElement element = waitForVisibilityOfElement(driver.findElement(locator));
        moveToElement(element);
        element.click();
        element.clear();
        element.sendKeys(inputText);
    }

    public static WebElement waitForVisibilityOfElement(WebElement locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOf(locator));
    }

    public static void selectDropdownByVisibleText(By locator, String optionText) {
        WebElement element = waitForVisibilityOfElement(driver.findElement(locator));
        new Select(element).selectByVisibleText(optionText);
    }

    public static void selectDropdownByIndex(By locator, int optionIndex) {
        WebElement element = waitForVisibilityOfElement(driver.findElement(locator));
        new Select(element).selectByIndex(optionIndex);
    }

    public static void moveToElement(WebElement locator) {
        new Actions(driver).moveToElement(locator).perform();
    }
}
