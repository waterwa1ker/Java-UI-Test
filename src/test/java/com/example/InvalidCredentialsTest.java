package com.example;

import com.example.config.ConfProperties;
import com.example.page.MainPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class InvalidCredentialsTest {

    private final static String ERROR_MESSAGE = "Неправильный логин или пароль";

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
    public void invalidCredentialsTest() {
        step1();
        step2();
        step3();
    }

    //Переходим к вводу почты и пароля
    private void step1() {
        mainPage.getWebElementByClass(MainPage.AUTH_BUTTON_CLASS).click();
        mainPage.getWebElementByClass(MainPage.ALREADY_REGISTERED_CLASS).click();
    }

    //Вводим неправильные данные
    private void step2() {
        mainPage.getWebElementById(MainPage.EMAIL_INPUT_ID).sendKeys(MainPage.EMAIL + "1");
        mainPage.getWebElementById(MainPage.PASSWORD_INPUT_ID).sendKeys(MainPage.PASSWORD);
        mainPage.getWebElementByClass(MainPage.SUBMIT_BUTTON_CLASS).click();
    }

    //Проверяем наличие ошибки
    private void step3() {
        Assert.assertEquals(mainPage.getErrorMessage().getText(), ERROR_MESSAGE);
    }

    @After
    public void tearDown() {
        if (driver != null ) {
            driver.quit();
        }
    }



}
