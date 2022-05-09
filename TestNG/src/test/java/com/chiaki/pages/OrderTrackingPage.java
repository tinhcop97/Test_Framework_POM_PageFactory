package com.chiaki.pages;

import core.WebUI;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OrderTrackingPage {
    WebDriver driver;
    WebDriverWait wait;

    @FindBy(xpath = "(//td[@class='order-code']//a)[1]")
    WebElement orderCode;

    public OrderTrackingPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void waitPageLoad() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(10));
        wait.until(ExpectedConditions.visibilityOf(orderCode));
    }

    public void clickOnOrderCode(){
        wait.until(vis)
        orderCode.click();
    }
}
