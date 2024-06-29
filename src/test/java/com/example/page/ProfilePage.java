package com.example.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProfilePage implements Page{

    public final static String INPUT_CLASS = "info_input";

    private WebDriver driver;
    private WebDriverWait driverWait;

    public ProfilePage(WebDriver driver) {
        this.driver = driver;
        driverWait = new WebDriverWait(driver, Duration.ofSeconds(1));
    }

    public WebElement getWebElementByClass(String className) {
        return driver.findElement(By.className(className));
    }

    public WebElement getWebElementById(String id) {
        return driver.findElement(By.id(id));
    }

    public WebElement getInfoInput() {
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.className(INPUT_CLASS)));
        return driver.findElement(By.className(INPUT_CLASS));
    }
}
