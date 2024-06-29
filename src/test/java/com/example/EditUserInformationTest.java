package com.example;

import com.example.config.ConfProperties;
import com.example.page.MainPage;
import com.example.page.ProfilePage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class EditUserInformationTest {

    private final static String NEW_NAME = "Adel";

    private WebDriver driver;
    private MainPage mainPage;
    private ProfilePage profilePage;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));
        driver = new ChromeDriver();
        driver.get(ConfProperties.getProperty("loginpage"));
        mainPage = new MainPage(driver);
        profilePage = new ProfilePage(driver);
    }

    @Test
    public void editUserInformationTest() throws InterruptedException {
        step1();
        step2();
        step3();
        step4();
        step5();
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

    //Переход к странице изменения профиля
    private void step3() throws InterruptedException {
        mainPage.getAuthButtonAfter().click();
        mainPage.getWebElementByClass(MainPage.USER_PROFILE_ROUTE_CLASS).click();
    }

    //Изменить имя пользователя
    //TODO
    private void step4() throws InterruptedException {
        profilePage.getInfoInput().clear();
        profilePage.getInfoInput().sendKeys(NEW_NAME);
        driver.navigate().refresh();
    }

    //Проверяем имя
    private void step5() {
        String nameAfterEdit = profilePage.getWebElementByClass(ProfilePage.INPUT_CLASS).getText();
        Assert.assertEquals(nameAfterEdit, NEW_NAME);
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }


}
