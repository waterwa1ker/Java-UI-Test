package com.example;

import com.example.config.ConfProperties;
import com.example.page.MainPage;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LogoutTest {

    private WebDriver driver;
    private MainPage mainPage;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));
        driver = new ChromeDriver();
        driver.get(ConfProperties.getProperty("loginpage"));
        mainPage = new MainPage(driver);
    }

    @Test
    public void logoutTest() {
        step1();
        step2();
        step3();
        step4();
    }

    //Переходим к вводу почты и пароля
    private void step1() {
        mainPage.getWebElementByClass(MainPage.AUTH_BUTTON_CLASS).click();
        mainPage.getWebElementByClass(MainPage.ALREADY_REGISTERED_CLASS).click();
    }

    //Заполняем данные и нажимаем "Войти"
    private void step2() {
        mainPage.getWebElementById(MainPage.EMAIL_INPUT_ID).sendKeys(MainPage.EMAIL);
        mainPage.getWebElementById(MainPage.PASSWORD_INPUT_ID).sendKeys(MainPage.PASSWORD);
        mainPage.getWebElementByClass(MainPage.SUBMIT_BUTTON_CLASS).click();
    }

    //Разлогиниться
    private void step3() {
        mainPage.getAuthButtonAfter().click();
        mainPage.getWebElementByClass(MainPage.LOGOUT_BUTTON_CLASS).click();
    }

    private void step4() {
        mainPage.getWebElementByClass(MainPage.AUTH_BUTTON_CLASS).click();
        Assert.assertTrue(mainPage.getWebElementByClass(MainPage.REGISTRATION_CONTENT_CLASS).isDisplayed());
    }



}
