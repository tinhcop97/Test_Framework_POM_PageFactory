package day4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class techpanda {
    WebDriver driver;

    @BeforeTest
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\dev\\Web Driver\\chromedriver_win32_ver99\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://live.techpanda.org/");
        driver.manage().window().maximize();

    }

    @Test
    public void test1() {
        /* go to http://live.techpanda.org/
        verify title of the page
        click on mobile menu
        verify title of the page
        in list, select sort by dropdown as name
        verify all products are sorted by name
         */


        try {
            WebElement h2 = driver.findElement(By.xpath("//h2"));
            String text = h2.getText();
            Assert.assertTrue(text.contains("THIS IS DEMO SITE"));
            Thread.sleep(2000);

            WebElement mobile = driver.findElement(By.xpath("//a[@class='level0 '][contains(.,'Mobile')]"));
            mobile.click();
            WebElement titleMobile = driver.findElement(By.xpath("//h1"));
            Assert.assertEquals(titleMobile.getText(), "MOBILE");
            Thread.sleep(2000);

            WebElement viewAsList = driver.findElement(By.xpath("(//a[@title='List'][normalize-space()='List'])[1]"));
            viewAsList.click();

            WebElement sortBy = driver.findElement(By.xpath("(//select[@title='Sort By'])[1]"));
//            WebElement sortBy = driver.findElement(By.xpath("//div[@class='category-products']/div[1]/descendant::select[@title='Sort By']"));
            sortBy.click();
            Select select = new Select(sortBy);
            select.selectByVisibleText("Name");
            Thread.sleep(2000);

            WebElement iphone = driver.findElement(By.xpath("//h2//a[@title='IPhone']"));
            Assert.assertEquals(iphone.getText(),"IPHONE");
            WebElement ss = driver.findElement(By.xpath("//h2//a[@title='Samsung Galaxy']"));
            Assert.assertEquals(ss.getText(),"SAMSUNG GALAXY");
            WebElement sony = driver.findElement(By.xpath("//h2//a[@title='Sony Xperia']"));
            Assert.assertEquals(sony.getText(),"SONY XPERIA");


        } catch (Exception e) {
            System.out.println("can't find");
        }
    }

    @AfterTest
    public void teardown() {
        driver.close();
    }
}
