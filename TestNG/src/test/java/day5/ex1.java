package day5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.interactions.Actions;




public class ex1 {
    WebDriver driver;

    @BeforeTest
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\dev\\Web Driver\\chromedriver_win32_ver95\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://demo.guru99.com/test/drag_drop.html");

    }

    @Test
    public void test1() {

        try {
            WebElement fromElement = driver.findElement(By.xpath("//div[@id='products']//descendant::li[2]"));

            WebElement toElement = driver.findElement(By.xpath("//ol[@id='amt7']"));

            Actions builder = new Actions(driver);

            builder.dragAndDrop(fromElement,toElement).build().perform();
            Thread.sleep(3000);

            WebElement debit = driver.findElement(By.xpath("//div[@id='t7']"));
            Assert.assertEquals(debit.getText(),"5000");

        } catch (Exception e) {
            System.out.println("can't find");
        }
    }

    @AfterTest
    public void teardown() {
        driver.close();
    }
}
