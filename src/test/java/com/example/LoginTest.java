package com.example;

import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

import java.util.concurrent.TimeUnit;

public class LoginTest {

    @FindBy(xpath = "//*contains[text(), 'Телефон')]")
    private WebElement telephoneButton;
    @FindBy(xpath = "//*[contains(@id, 'passp-field-phone')]")
    private WebElement loginField;
    @FindBy(xpath = "//*[contains(text(), 'Войти')]")
    private WebElement loginButton;

    public WebDriver webDriver;

    public LoginTest(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void inputPhone(String phone) {
        loginField.sendKeys(phone);
    }

    public void clickPhoneButton() {
        telephoneButton.click();
    }

    public void clickLoginButton() {
        loginButton.click();
    }

    @BeforeClass
    public void setup() {
        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));
        WebDriver driver = new ChromeDriver();
        driver
                .manage()
                .window()
                .maximize();
        driver
                .manage()
                .timeouts()
                .implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(ConfProperties.getProperty("loginpage"));
    }

}
