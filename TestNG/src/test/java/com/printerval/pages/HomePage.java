package com.printerval.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {
    private WebDriver driver;

    @FindBy(xpath = "//img[@alt=\"Printerval | Spice up your life\"]")
    private WebElement logoPage;

    @FindBy(id = "js-search-text")
    private WebElement searchBox;

    @FindBy(xpath = "//button[@class=\"button search-button\"]")
    private WebElement iconSearch;




}
