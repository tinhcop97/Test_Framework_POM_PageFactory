import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.IOException;
import java.util.Set;

public class demo {
    WebDriver driver;

    @BeforeTest
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\dev\\Web Driver\\chromedriver_win32_ver99\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://live.techpanda.org/");
    }

    @Test
    public void test() throws InterruptedException {

        driver.findElement(By.xpath("//a[normalize-space()='Mobile']")).click();//click btn mobile
        String productName_mainWindow = driver.findElement(By.xpath("//a[normalize-space()='IPhone']")).getText();//text productName popupWindow
        System.out.println(productName_mainWindow);

        String mainWindow = driver.getWindowHandle();

        WebElement btn_Compare = driver.findElement(By.xpath("//li[1]//div[1]//div[3]//ul[1]//li[2]//a[1]"));//click vao nut btn add to compare
        btn_Compare.click();
        //driver.findElement(btn_Compare).click();

        Set<String> listWindows = driver.getWindowHandles();

        for (String window : listWindows) {
            if (!mainWindow.equalsIgnoreCase(window)) {
                driver.switchTo().window(window);
                String productName_popupWindow = driver.findElement(By.xpath("//a[normalize-space()='IPhone']")).getText();//text product name
                System.out.println(productName_popupWindow);
                Assert.assertEquals(driver.findElement(By.xpath("//h1[normalize-space()='Compare Products']")).getText(), "COMPARE PRODUCTS");
                Assert.assertEquals(productName_mainWindow, productName_popupWindow);
                driver.close();
            }

        }
        //kiem tra popupWindow đã đóng chưa
        driver.switchTo().window(mainWindow);

        Set<String> listWindows_AfterClose = driver.getWindowHandles();

        Assert.assertEquals(listWindows_AfterClose.size(), 1);
    }
    @AfterTest
    public void closeTest() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
    }
}
