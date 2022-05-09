package com.chiaki.pages;

import core.WebUI;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class HomePage {
    WebDriver driver;
    WebDriverWait wait;

    @FindBy(id = "keyword")
    WebElement searchBox;

    @FindBy(xpath = "//ul[@id='search-suggestion']//li[5]")
    WebElement itemFirst;

    @FindBy(xpath = "//ul[@id='search-suggestion']//li[5]//a[1]")
    WebElement hrefInSearch;

    @FindBy(xpath = "//ul[@id='search-suggestion']//li[5]//descendant::span[@class='title-search']")
    WebElement nameInSearch;

    @FindBy(xpath = "//ul[@id='search-suggestion']//li[5]//descendant::div[@class='search-new-price']")
    WebElement priceInSearch;

    @FindBy(xpath = "//ul[@id='search-suggestion']//li[5]//descendant::span[@class='old-price-value']")
    WebElement oldPriceInSearch;

    @FindBy(xpath = "//div[@class='segment-order-text']")
    WebElement ordertracking;

    @FindBy(xpath = "//ul[@id='search-suggestion']//a[@class='search-in-category']")
    List<WebElement> searchCategoryElements;

    @FindBy(xpath = "//ul[@id='search-suggestion']//*[contains(@id,'search-suggestion-template')]//span[@class='title-search']")
    List<WebElement> searchSuggestionElements;



//    String nameInSearchText = nameInSearch.getText();
//    String priceInSearchText = priceInSearch.getText();
//    String oldPriceInSearchText = oldPriceInSearch.getText();
//    String linkInSearch = hrefInSearch.getAttribute("href");

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void searchInHomePage(String value) {
        searchBox.clear();
        searchBox.sendKeys(value);
        WebUI.sleep(1);
    }

    public void waitShowSearchResult(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(10));
//        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
        wait.until(ExpectedConditions.visibilityOf(itemFirst));
    }

    public void clickOnFirstItem(){
        itemFirst.click();
    }

    public String getNameInSearch() {
        return nameInSearch.getText();
    }

    public String getHrefInSearch(){
        return hrefInSearch.getAttribute("href");
    }

    public String getPriceInSearch(){
        return priceInSearch.getText();
    }

    public String getOldPriceInSearch(){
        return oldPriceInSearch.getText();
    }

    public List<WebElement> getSearchSuggestionElements(){return searchSuggestionElements;}

    public List<WebElement> getSearchCategoryElements(){return searchCategoryElements;}



}


