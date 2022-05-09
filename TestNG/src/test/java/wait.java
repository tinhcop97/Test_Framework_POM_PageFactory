import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class wait {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\dev\\Web Driver\\chromedriver_win32_ver99\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("http://95.111.196.180/");

        WebElement item = driver.findElement(By.xpath("//img[@title='Disney Encanto Birthday Shirts']"));
        clickOn(driver,item,10);

        WebElement color = driver.findElement(By.xpath("//img[@title='Navy']"));
        clickOn(driver,color,10);

        WebElement chooseSizeDropDown = driver.findElement(By.id("js-select-variant-1"));
        Select size = new Select(chooseSizeDropDown);
        size.selectByValue("1");

        WebElement customizeNowBtn = driver.findElement(By.xpath("//button[normalize-space()='Customize Now']"));
        clickOn(driver,customizeNowBtn,10);

        WebElement type = driver.findElement(By.xpath("//span[@class='custom-product-popup-radio-selector-select custom-product-popup-radio-name ng-binding'][normalize-space()='Youth']"));
        clickOn(driver,type,10);

        WebElement color1 = driver.findElement(By.xpath("//img[@title='Navy']"));
        clickOn(driver,color1,10);

        WebElement enterText = driver.findElement(By.xpath("//input[@placeholder='Enter Your Text Here']"));
        sendkeys(driver,enterText,10,"My text");

        WebElement side = driver.findElement(By.xpath("//span[normalize-space()='Back']"));
        clickOn(driver,side,10);

        WebElement quantity = driver.findElement(By.xpath("//input[@id='quantity']"));
        quantity.clear();
        sendkeys(driver,quantity,10,"20");

//        WebDriver wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        WebElement addToCart = driver.findElement(By.xpath("//div[@class='custom-product-popup-action-wrapper flex-b align-c']//following-sibling::button"));
        clickOn(driver,addToCart,10);



        WebElement miniShoppingCart = driver.findElement(By.id("mini-shopping-cart"));
        if (miniShoppingCart.isDisplayed())
            System.out.println("pass");


    }

    public static void sendkeys(WebDriver driver1, WebElement element, int timeout, String value) {
        new WebDriverWait(driver1, timeout).until(ExpectedConditions.visibilityOf(element));
        element.sendKeys(value);
    }

    public static void clickOn(WebDriver driver1, WebElement element, int timeout) {
        new WebDriverWait(driver1, timeout).until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

}
