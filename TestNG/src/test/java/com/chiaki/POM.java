package com.chiaki;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

// about:blank
public class POM {
    // No page elements added

    public POM(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}