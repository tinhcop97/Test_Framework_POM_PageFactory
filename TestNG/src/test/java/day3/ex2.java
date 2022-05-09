package day3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ex2 {
    WebDriver driver;

    @BeforeTest
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\dev\\Web Driver\\chromedriver_win32_ver95\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.walmart.com/ip/Hisense-65-inch-A6G-Series-4K-UHD-Android-Smart-TV-65A6G/996196793");
        driver.manage().window().maximize();

    }

    @Test
    public void test1() {
//        Write the selectors of element by Id, Name, Class, XPath as below:
//  Title product
//- Price of product
//- Free shipping info
//- None tab, 2 Year tab
//- Qty combobox
//- Add to Cart button
//- Add to list
//- Add to Registry

        try{
            WebElement title = driver.findElement(By.xpath("//h1"));
            System.out.println(title.getText());
            Thread.sleep(1000);

            WebElement price = driver.findElement(By.xpath("//div[@class='f6 gray lh-title mb3 dn db-m']//span[@itemprop='price'][normalize-space()='$499.99']"));
            System.out.println(price.getText());
            Thread.sleep(1000);

            WebElement freeShip = driver.findElement(By.xpath("//span[contains(text(),'Free shipping,')]"));
            System.out.println(freeShip.getText());
            Thread.sleep(1000);

            WebElement tab1 = driver.findElement(By.xpath("//label[.='4-Year plan - $69.00']"));
            System.out.println(tab1.getText());
            Thread.sleep(1000);

            WebElement tab2 = driver.findElement(By.xpath("//label[.='5-Year plan - $82.00']"));
            System.out.println(tab2.getText());
            Thread.sleep(1000);

            WebElement addToCart = driver.findElement(By.xpath("span[style$='visibility: visible;']"));
            WebElement addToList = driver.findElement(By.xpath("//button[contains(.,'Add to list')]"));
            WebElement addToRegister = driver.findElement(By.xpath("//button[contains(.,'Add to registry')]"));



        } catch (Exception e){
            System.out.println("can't find");
        }
    }

    @AfterTest
    public void teardown() {
        driver.close();
    }
}
