package com.chiaki.pages;

import core.WebUI;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Cart {
    WebDriver driver;

    @FindBy(xpath = "//div[@class='other-address']//div[@class='default-form']//input[@name='delivery_full_name']")
    WebElement fullName;

    @FindBy(xpath = "//div[@class='other-address']//div[@class='default-form']//input[@name='delivery_email']")
    WebElement email;

    @FindBy(xpath = "//div[@class='other-address']//div[@class='default-form']//input[@name='delivery_phone']")
    WebElement phone;

    @FindBy(xpath = "//div[@class='other-address']//div[@class='default-form']//select[@name='delivery_location_id']")
    WebElement provinceDropDown;

    @FindBy(xpath = "//div[@class='other-address']//div[@class='default-form']//select[@name='delivery_district_id']")
    WebElement districtDropDown;

    @FindBy(xpath = "//div[@class='other-address']//div[@class='default-form']//select[@name='delivery_commune_id']")
    WebElement communeDropDown;

    @FindBy(xpath = "//div[@class='other-address']//div[@class='default-form']//input[@name='delivery_address']")
    WebElement address;

    @FindBy(xpath = "//div[@class='other-address']//div[@class='default-form']//select[@name='delivery_shipping_time']")
    WebElement deliveryNoteDropDown;

    @FindBy(xpath = "//div[@class='other-address']//div[@class='default-form']//textarea")
    WebElement noteArea;

    @FindBy(xpath = "//div[@class='cartItemBox']//a[@class='title']")
    WebElement hrefInCart;

    @FindBy(xpath = "//tbody[@id='orderItem']//tr[1]//div[@class='quantity']//input")
    WebElement quantityInCart;

    @FindBy(xpath = "//div[@class='tt-price']//span")
    WebElement subTotal;

    @FindBy(xpath = "//div[@class='BuyAction']//button")
    WebElement orderBtn;

//    String quantityInCartValue = quantityInCart.getAttribute("value");
//    String subTotalValue = subTotal.getText();
//    String linkInCart = hrefInCart.getAttribute("href");

    public Cart(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void waitPageLoad() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(10));
//        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
        wait.until(ExpectedConditions.visibilityOf(fullName));
    }

    public void inputOrderInfoAndOrder(String fullNameValue, String emailValue, String phoneValue, String provinceValue, String districtValue, String communeValue, String addressValue, String deliveryNoteDropDownValue, String noteAreaValue) {
        fullName.sendKeys(fullNameValue);
        email.sendKeys(emailValue);
        phone.sendKeys(phoneValue);
        chooseDropDown(provinceDropDown, provinceValue);
        chooseDropDown(districtDropDown, districtValue);
        chooseDropDown(communeDropDown, communeValue);
        address.clear();
        address.sendKeys(addressValue);
        chooseDropDown(deliveryNoteDropDown, deliveryNoteDropDownValue);
        noteArea.sendKeys(noteAreaValue);
        orderBtn.click();

    }

    public void chooseDropDown(WebElement element, String visibleTextValue) {
        element.click();
        WebUI.sleep(1);
        Select choose = new Select(element);
        choose.selectByVisibleText(visibleTextValue);
    }

    public String getQuantityInCart(){
        return quantityInCart.getAttribute("data-select");
    }

    public String getSubTotal(){
        return subTotal.getText();
    }

    public String getHrefInCart() {
        return hrefInCart.getAttribute("href");
    }




}
