package test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

import static java.awt.SystemColor.control;

public class chiaki {
    public static void main(String[] args) {

        try {
            WebDriver driver;
            System.setProperty("webdriver.chrome.driver", "C:\\dev\\Web Driver\\chromedriver_win32_ver99\\chromedriver.exe");
            driver = new ChromeDriver();
            WebDriverWait wait = new WebDriverWait(driver,Duration.ofMinutes(20));
            driver.navigate().to("https://chiaki.vn/");
            driver.manage().window().maximize();

            WebElement searchBox = driver.findElement(By.id("keyword"));
            searchBox.clear();
            searchBox.sendKeys("Collagen");

            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//ul[@id='search-suggestion']//li[5]")));
            WebElement itemFirst = driver.findElement(By.xpath("//ul[@id='search-suggestion']//li[5]"));
            WebElement hrefInSearch = driver.findElement(By.xpath("//ul[@id='search-suggestion']//li[5]//a"));
            WebElement nameInSearch = driver.findElement(By.xpath("//ul[@id='search-suggestion']//li[5]//descendant::span[@class='title-search']"));
            WebElement priceInSearch = driver.findElement(By.xpath("//ul[@id='search-suggestion']//li[5]//descendant::div[@class='search-new-price']"));
            WebElement oldPriceInSearch = driver.findElement(By.xpath("//ul[@id='search-suggestion']//li[5]//descendant::span[@class='old-price-value']"));
            System.out.println(nameInSearch.getText()+priceInSearch.getText()+oldPriceInSearch.getText()+hrefInSearch.getAttribute("href"));

            itemFirst.click();

            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='buy-product-action']//following-sibling::span[@id='js-mua-hang']")));
            WebElement nameInDetail = driver.findElement(By.xpath("//span[@id='js-product-title']"));
            WebElement quantityInDetail = driver.findElement(By.xpath("//div[@class='buy-product-action']//descendant::input"));
            WebElement priceInDetail = driver.findElement(By.id("price-show"));
            WebElement oldPriceInDetail = driver.findElement(By.id("sale-price-show"));
            System.out.println(nameInDetail.getText()+priceInDetail.getText()+oldPriceInDetail.getText()+quantityInDetail.getAttribute("value"));

            quantityInDetail.click();
            quantityInDetail.sendKeys(Keys.CONTROL+"A");
            quantityInDetail.sendKeys("2");
            WebElement buyNowBtn = driver.findElement(By.xpath("//div[@class='buy-product-action']//following-sibling::span[@id='js-mua-hang']"));
            buyNowBtn.click();

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='other-address']//div[@class='default-form']//input[@name='delivery_full_name']")));
            WebElement fullName = driver.findElement(By.xpath("//div[@class='other-address']//div[@class='default-form']//input[@name='delivery_full_name']"));
            WebElement email = driver.findElement(By.xpath("//div[@class='other-address']//div[@class='default-form']//input[@name='delivery_email']"));
            WebElement phone = driver.findElement(By.xpath("//div[@class='other-address']//div[@class='default-form']//input[@name='delivery_phone']"));
            WebElement provinceDropDown = driver.findElement(By.xpath("//div[@class='other-address']//div[@class='default-form']//select[@name='delivery_location_id']"));
            WebElement districtDropDown = driver.findElement(By.xpath("//div[@class='other-address']//div[@class='default-form']//select[@name='delivery_district_id']"));
            WebElement communeDropDown = driver.findElement(By.xpath("//div[@class='other-address']//div[@class='default-form']//select[@name='delivery_commune_id']"));
            WebElement address = driver.findElement(By.xpath("//div[@class='other-address']//div[@class='default-form']//input[@name='delivery_address']"));
            WebElement noteDropDown = driver.findElement(By.xpath("//div[@class='other-address']//div[@class='default-form']//select[@name='delivery_shipping_time']"));
            WebElement noteArea = driver.findElement(By.xpath("//div[@class='other-address']//div[@class='default-form']//textarea"));
            WebElement hrefInCart = driver.findElement(By.xpath("//div[@class='cartItemBox']//a[@class='title']"));
            WebElement quantityInCart = driver.findElement(By.xpath("//div[@class='quantity']//input"));
            WebElement subTotal = driver.findElement(By.xpath("//div[@class='tt-price']//span"));

            System.out.println(hrefInCart.getAttribute("href")+subTotal.getText()+quantityInCart.getAttribute("value"));

            fullName.sendKeys("Kỹ thuật test");
            email.sendKeys("test@gmail.com");
            phone.sendKeys("0123456789");
            wait.until(ExpectedConditions.elementToBeClickable(provinceDropDown));
            provinceDropDown.click();
            Select chooseProvince = new Select(provinceDropDown);
            chooseProvince.selectByValue("24");
            wait.until(ExpectedConditions.elementToBeClickable(districtDropDown));
            districtDropDown.click();
            Thread.sleep(500);
            Select chooseDistrict = new Select(districtDropDown);
            chooseDistrict.selectByValue("70_1");
            wait.until(ExpectedConditions.elementToBeClickable(communeDropDown));
            communeDropDown.click();
            Select chooseCommune = new Select(communeDropDown);
            chooseCommune.selectByValue("2662");
            address.clear();
            address.sendKeys("Kỹ thuật test");
            noteDropDown.click();
            Select chooseNoteType = new Select(noteDropDown);
            chooseNoteType.selectByVisibleText("Thêm ghi chú");
            noteArea.sendKeys("Kỹ thuật test");

            Assert.assertTrue(hrefInCart.getAttribute("href").contains(hrefInSearch.getAttribute("href")),"Same Link");
            Assert.assertEquals(nameInDetail.getText(),nameInSearch.getText(),"Same Name");
            Assert.assertEquals(priceInDetail,priceInSearch,"Same Price");
            Assert.assertEquals(oldPriceInDetail,oldPriceInSearch,"Same Old Price");



        } catch (Exception e){}
    }
}
