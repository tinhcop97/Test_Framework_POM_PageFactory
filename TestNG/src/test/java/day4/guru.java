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

public class guru {
    WebDriver driver;

    @BeforeTest
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\dev\\Web Driver\\chromedriver_win32_ver95\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://demo.guru99.com/V1/index.php");
        driver.manage().window().maximize();

    }

    @Test
    public void test1() {
        /* go to https://demo.guru99.com/V1/index.php
        enter valid user id
        enter valid password
        click login
        verify the output

        mngr364094/uvururY
         */


        try {
            WebElement user = driver.findElement(By.name("uid"));
            user.sendKeys("mngr364094");

            WebElement pass = driver.findElement(By.name("password"));
            pass.sendKeys("uvururY");

            WebElement loginBtn = driver.findElement(By.name("btnLogin"));
            loginBtn.click();
            Thread.sleep(3000);

            WebElement marquee = driver.findElement(By.xpath("//marquee"));
            Assert.assertEquals(marquee.getText(),"Welcome To Manager's Page of GTPL Bank");





        } catch (Exception e) {
            System.out.println("can't find");
        }
    }

    @AfterTest
    public void teardown() {
        driver.close();
    }
}
