package day6;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ex3 {
    WebDriver driver;

    @BeforeTest
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\dev\\Web Driver\\chromedriver_win32_ver99\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.w3schools.com/html/tryit.asp?filename=tryhtml_iframe_height_width");
    }
    @Test
    public void test(){
        WebElement iframe=driver.findElement(By.xpath("//iframe[@id='iframeResult']"));
        driver.switchTo().frame(iframe);
        WebElement titleParent=driver.findElement(By.xpath("//h2[normalize-space()='HTML Iframes']"));
        System.out.println((titleParent).getText());
        driver.switchTo().frame(0);
        String text_IframeChildActual = driver.findElement(By.xpath("//body[@style='background-color:powderblue']//h1")).getText();
        System.out.println(text_IframeChildActual);
        Assert.assertEquals(text_IframeChildActual, "This page is displayed in an iframe");


    }
    @AfterTest
    public void closeTest() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
    }
}
