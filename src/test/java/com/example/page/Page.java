package com.example.page;

import org.openqa.selenium.WebElement;

public interface Page {

    WebElement getWebElementByClass(String className);
    WebElement getWebElementById(String id);

}