package test;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.nio.charset.StandardCharsets;
import java.time.Duration;

public class BuySuccess {
    WebDriver driver;

    public int toNumber(String price) {
        price = price.replace(".", "");
        price = price.replace("đ", "");
        int priceNum = Integer.parseInt(price);
        return priceNum;
    }

    //    WebDriverWait wait;
    @BeforeTest
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\dev\\Web Driver\\chromedriver_win32_ver99\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://chiaki.vn/");
        driver.manage().window().maximize();
    }

    @Test
    public void testBuy() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("keyword")));
        WebElement searchBox = driver.findElement(By.id("keyword"));
        searchBox.clear();
        searchBox.sendKeys("Collagen");

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//ul[@id='search-suggestion']//li[5]")));
        WebElement itemFirst = driver.findElement(By.xpath("//ul[@id='search-suggestion']//li[5]"));
        WebElement hrefInSearch = driver.findElement(By.xpath("//ul[@id='search-suggestion']//li[5]//a"));
        WebElement nameInSearch = driver.findElement(By.xpath("//ul[@id='search-suggestion']//li[5]//descendant::span[@class='title-search']"));
        WebElement priceInSearch = driver.findElement(By.xpath("//ul[@id='search-suggestion']//li[5]//descendant::div[@class='search-new-price']"));
        WebElement oldPriceInSearch = driver.findElement(By.xpath("//ul[@id='search-suggestion']//li[5]//descendant::span[@class='old-price-value']"));

        String nameInSearchText = nameInSearch.getText();
        String priceInSearchText = priceInSearch.getText();
        String oldPriceInSearchText = oldPriceInSearch.getText();
        String linkInSearch = hrefInSearch.getAttribute("href");

//        System.out.println(nameInSearch.getText() + priceInSearch.getText() + oldPriceInSearch.getText() + hrefInSearch.getAttribute("href"));

        itemFirst.click();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='buy-product-action']//following-sibling::span[@id='js-mua-hang']")));
        WebElement nameInDetail = driver.findElement(By.xpath("//span[@id='js-product-title']"));
        WebElement quantityInDetail = driver.findElement(By.xpath("//div[@class='buy-product-action']//descendant::input"));
        WebElement priceInDetail = driver.findElement(By.id("price-show"));
        WebElement oldPriceInDetail = driver.findElement(By.id("sale-price-show"));

        String nameInDetailText = nameInDetail.getText();
//        String quantityInDetailValue = quantityInDetail.getAttribute("value");
        String priceInDetailText = priceInDetail.getText();
        String oldPriceInDetailText = oldPriceInDetail.getText();

//        System.out.println(nameInDetail.getText() + priceInDetail.getText() + oldPriceInDetail.getText() + quantityInDetail.getAttribute("value"));

        quantityInDetail.click();
        quantityInDetail.sendKeys(Keys.CONTROL + "A");
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
        WebElement orderBtn = driver.findElement(By.xpath("//div[@class='BuyAction']//button"));

        String quantityInCartValue = quantityInCart.getAttribute("value");
        String subTotalValue = subTotal.getText();
        String linkInCart = hrefInCart.getAttribute("href");

//        System.out.println(hrefInCart.getAttribute("href") + subTotal.getText() + quantityInCart.getAttribute("value"));

        fullName.sendKeys("Kỹ thuật test");
        email.sendKeys("test@gmail.com");
        phone.sendKeys("0368123456");
        wait.until(ExpectedConditions.elementToBeClickable(provinceDropDown));
        provinceDropDown.click();
        Select chooseProvince = new Select(provinceDropDown);
        chooseProvince.selectByVisibleText("Hà Nội");
        districtDropDown.click();
        Thread.sleep(1000);
        Select chooseDistrict = new Select(districtDropDown);
        chooseDistrict.selectByVisibleText("Quận Ba Đình");
        communeDropDown.click();
        Thread.sleep(1000);
        Select chooseCommune = new Select(communeDropDown);
        chooseCommune.selectByVisibleText("Phường Kim Mã");
        address.clear();
        address.sendKeys("Kỹ thuật test");
        noteDropDown.click();
        Select chooseNoteType = new Select(noteDropDown);
        chooseNoteType.selectByVisibleText("Thêm ghi chú");
        noteArea.sendKeys("Kỹ thuật test");
        orderBtn.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='login-title']")));
        WebElement title = driver.findElement(By.xpath("//div[@class='login-title']"));

        Assert.assertTrue(linkInCart.contains(linkInSearch), "Link Not Match");
//        Assert.assertEquals(nameInDetailText,nameInSearchText, "Name Not Match");
        Assert.assertEquals(priceInDetailText, priceInSearchText, "Price Not Match");
        Assert.assertEquals(oldPriceInDetailText, oldPriceInSearchText, "Old Price Not Match");
        Assert.assertEquals(toNumber(quantityInCartValue), 2, "Quantity Not Match");
        Assert.assertEquals(toNumber(priceInDetailText) * toNumber(quantityInCartValue), toNumber(subTotalValue), "Subtotal Not Match");
        Assert.assertEquals(title.getText(),"ĐẶT HÀNG THÀNH CÔNG","Notify Not Match");

    }

    @AfterTest
    public void teardown() throws InterruptedException {
        Thread.sleep(5000);
        driver.close();
    }
}
