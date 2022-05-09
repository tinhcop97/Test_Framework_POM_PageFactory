package com.chiaki.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductDetailPage {
    WebDriver driver;

    @FindBy(xpath = "//span[@id='js-product-title']")
    WebElement nameInDetail;

    @FindBy(xpath = "//div[@class='buy-product-action']//descendant::input")
    WebElement quantityInDetail;

    @FindBy(id = "price-show")
    WebElement priceInDetail;

    @FindBy(id = "sale-price-show")
    WebElement oldPriceInDetail;

    @FindBy(xpath = "//div[@class='buy-product-action']//following-sibling::span[@id='js-mua-hang']")
    WebElement buyNowBtn;

//    String nameInDetailText = nameInDetail.getText();
//    String quantityInDetailValue = quantityInDetail.getAttribute("value");
//    String priceInDetailText = priceInDetail.getText();
//    String oldPriceInDetailText = oldPriceInDetail.getText();

    public ProductDetailPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void waitPageLoad() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(10));
//        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
        wait.until(ExpectedConditions.visibilityOf(nameInDetail));
    }

    public void inputQuantityAndBuyNow(String value){
        quantityInDetail.click();
        quantityInDetail.sendKeys(Keys.CONTROL + "A");
        quantityInDetail.sendKeys(value);
        buyNowBtn.click();
    }

    public String getPriceInDetail(){
        return priceInDetail.getText();
    }

    public String getOldPriceInDetail(){
        return oldPriceInDetail.getText();
    }

//    public String getQuantityInDetail(){return quantityInDetail.getText();}

}
