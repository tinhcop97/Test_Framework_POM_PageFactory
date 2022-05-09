package day3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ex3 {
    WebDriver driver;

    @BeforeTest
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\dev\\Web Driver\\chromedriver_win32_ver95\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.booking.com");
        driver.manage().window().maximize();

    }

    @Test
    public void test1() {
//        1. Hit the URL: https://www.booking.com in Chrome browser.
//        2. Click Register on top page
//        3. Look for Register tab and write the selectors of element by Id, Name, Class, XPath as below:
//        - Email Address textbox
//        - Get started button
//        - Sign up with Facebook

        try{
            WebElement register = driver.findElement(By.xpath("/html[1]/body[1]/header[1]/nav[1]/div[2]/div[5]/a[1]/span[1]"));
            register.click();
            Thread.sleep(1000);

            WebElement email = driver.findElement(By.id("username"));
            email.sendKeys("tinhcop97@gmail.com");
            Thread.sleep(1000);

//            WebElement btn = driver.findElement(By.xpath("//span[contains(.,'email')]"));
//            btn.click();
//            Thread.sleep(1000);

            WebElement withFB = driver.findElement(By.xpath("//a[contains(@title,'Facebook')]"));
            withFB.click();
            Thread.sleep(1000);





        } catch (Exception e){
            System.out.println("can't find");
        }
    }

    @AfterTest
    public void teardown() {
        driver.close();
    }
}
