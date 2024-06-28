package com.example.page;


import com.example.config.ConfProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage {

    public final static String AUTH_BUTTON_CLASS = "header-login-icon";
    public final static String ALREADY_REGISTERED_CLASS = "blue-text";
    public final static String EMAIL_INPUT_ID = "emailLog";
    public final static String PASSWORD_INPUT_ID = "passwordLog";
    public final static String SUBMIT_BUTTON_CLASS = "registration-button";
    public final static String USER_NAME_CLASS = "user_name";
    public final static String AUTH_BUTTON_AFTER_CLASS = "auth";
    public final static String ERROR_MESSAGE_AUTH_CLASS = "registration_confirm_text";

    public final static String EMAIL = ConfProperties.getProperty("email");
    public final static String PASSWORD = ConfProperties.getProperty("password");

    private WebDriver driver;
    private WebDriverWait driverWait;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        this.driverWait = new WebDriverWait(driver, Duration.ofSeconds(1));
    }

    public WebElement getWebElementByClass(String className) {
        return driver.findElement(By.className(className));
    }

    public WebElement getWebElementById(String id) {
        return driver.findElement(By.id(id));
    }


    public WebElement getUserName() {
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.className(USER_NAME_CLASS)));
        return getWebElementByClass(USER_NAME_CLASS);
    }

    public WebElement getAuthButtonAfter() {
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.className(AUTH_BUTTON_AFTER_CLASS)));
        return getWebElementByClass(AUTH_BUTTON_AFTER_CLASS);
    }

    public WebElement getErrorMessage() {
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.className(ERROR_MESSAGE_AUTH_CLASS)));
        return getWebElementByClass(ERROR_MESSAGE_AUTH_CLASS);
    }


}
