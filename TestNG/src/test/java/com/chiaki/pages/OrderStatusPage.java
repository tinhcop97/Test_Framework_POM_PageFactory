package com.chiaki.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderStatusPage {
    WebDriver driver;

    @FindBy(xpath = "//div[@class='login-title']")
    WebElement title;

    @FindBy(xpath = "//div[@class='form-sms-verify']//following-sibling::p//a[@target='_blank']")
    WebElement bamVaoDay_orderTracking;

    public OrderStatusPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public OrderTrackingPage clickToTrackingOrder(){
        bamVaoDay_orderTracking.click();
        return new OrderTrackingPage(driver);
    }

    public String getStatus() {
        return title.getText();
    }



}
