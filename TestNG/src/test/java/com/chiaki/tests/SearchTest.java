package com.chiaki.tests;

import com.chiaki.pages.Cart;
import com.chiaki.pages.HomePage;
import com.chiaki.pages.OrderStatusPage;
import com.chiaki.pages.ProductDetailPage;
import constants.FrameworkConstants;
import core.WebUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class SearchTest {
    WebDriver driver;
    HomePage homePage;

    @BeforeTest
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\dev\\Web Driver\\chromedriver_win32_ver99\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(FrameworkConstants.BASE_URl);
        driver.manage().window().maximize();
    }

    @Test()
    public void search_in_category() throws InterruptedException {

        homePage = new HomePage(driver);
        homePage.searchInHomePage("Collagen");
        homePage.waitShowSearchResult();
        int numOfSearchCategory = homePage.getSearchCategoryElements().size();

        for (int i = 0; i < numOfSearchCategory; i++) {
            String temp = homePage.getSearchCategoryElements().get(i).getText();

//            if ((driver.findElement(By.xpath("(//a[@class='search-in-category'])[i]")).getText().contains("Collagen trong"))) {
            if (temp.contains("Collagen trong")) {
                Assert.assertTrue(true, "Đúng format: " + temp);
            } else {
                Assert.assertTrue(false, "Không đúng format: " + temp);
            }
        }
    }

    @Test()
    public void search_suggestion() throws InterruptedException {

        homePage = new HomePage(driver);
        homePage.searchInHomePage("Collagen");
        homePage.waitShowSearchResult();
        int numOfSearchSuggestion = homePage.getSearchSuggestionElements().size();

//        List<WebElement> searchResults = driver.findElements(By.xpath("//ul[@id='search-suggestion']//*[contains(@id,'search-suggestion-template')]//span[@class='title-search']"));
        for (int i = 0; i < numOfSearchSuggestion; i++) {
            String temp = homePage.getSearchSuggestionElements().get(i).getText();

            Assert.assertTrue(numOfSearchSuggestion == 5, "Show ra số kết quả khác 5");

            if ((temp.toLowerCase().contains("Collagen".toLowerCase()))) {
                Assert.assertTrue(true, "Collagen is displayed on product title Product Title: " + temp);
            } else {
                Assert.assertTrue(false, "Collagen is not displayed on product title Product Title: " + temp);
            }
        }
    }

    @AfterTest
    public void teardown() throws InterruptedException {
        Thread.sleep(1000);
        driver.quit();
    }
}
