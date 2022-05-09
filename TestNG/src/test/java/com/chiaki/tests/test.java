package com.chiaki.tests;

import com.chiaki.pages.*;
import constants.FrameworkConstants;
import core.WebUI;
import helpers.PropertiesHelpers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class test{
    WebDriver driver;
    HomePage homePage;
    ProductDetailPage productDetailPage;
    Cart cart;
    OrderStatusPage orderStatusPage;
    OrderTrackingPage orderTrackingPage;


    @BeforeTest
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\dev\\Web Driver\\chromedriver_win32_ver99\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(FrameworkConstants.BASE_URl);
        driver.manage().window().maximize();
    }

    @Test(priority = 1)
    public void fromSearchToOrderSucess() throws InterruptedException {
        homePage = new HomePage(driver);
        homePage.searchInHomePage("Collagen");
        homePage.waitShowSearchResult();
        String priceInSearch = homePage.getPriceInSearch();
        String oldPriceInSearch = homePage.getOldPriceInSearch();
        String hrefInSearch = homePage.getHrefInSearch();
        homePage.clickOnFirstItem();

        productDetailPage = new ProductDetailPage(driver);
        productDetailPage.waitPageLoad();
        productDetailPage.inputQuantityAndBuyNow("2");
        String priceInDetail = productDetailPage.getPriceInDetail();
        String oldPriceInDetail = productDetailPage.getOldPriceInDetail();
//        String quantityInDetail = productDetailPage.getQuantityInDetail();

        cart = new Cart(driver);
        cart.waitPageLoad();
        String quantityInCart = cart.getQuantityInCart();
        String subTotal = cart.getSubTotal();
        String hrefInCart = cart.getHrefInCart();
        cart.inputOrderInfoAndOrder("Kỹ thuật test","test@gmail.com","0948123529"
                ,"Hà Nội","Quận Ba Đình","Phường Kim Mã","Kỹ thuật test"
                ,"Thêm ghi chú","Kỹ thuật test");

        orderStatusPage = new OrderStatusPage(driver);
        String orderStatus = orderStatusPage.getStatus();
        orderStatusPage.clickToTrackingOrder();

        orderTrackingPage = new OrderTrackingPage(driver);
        orderTrackingPage.waitPageLoad();
        orderTrackingPage.clickOnOrderCode();

        Assert.assertTrue(hrefInCart.contains(hrefInSearch),"Href Not Match");
        Assert.assertEquals(priceInDetail,priceInSearch,"Price Not Match");
        Assert.assertEquals(oldPriceInDetail,oldPriceInSearch,"Old Price Not Match");
        Assert.assertEquals(WebUI.toNumber(quantityInCart),2,"Quantity Not Match Inputted");
        Assert.assertEquals(WebUI.toNumber(priceInDetail)*WebUI.toNumber(quantityInCart),WebUI.toNumber(subTotal),"Subtotal Not Match");
        Assert.assertEquals(orderStatus,"ĐẶT HÀNG THÀNH CÔNG","Notify Not Match");

    }

    @AfterTest
    public void teardown() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }

}
