package day2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Exercise2 {
    WebDriver driver;

    @BeforeTest
    public void setup(){
        System.setProperty("webdriver.chrome.driver","C:\\dev\\Web Driver\\chromedriver_win32_ver99\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://tiki.vn/");

    }

    @Test
    public void test(){
        System.out.println("This test verifies title of tiki.vn");
        String title = driver.getTitle();
        System.out.println("Title is: " + title);
        Assert.assertTrue(title.contains("tiki.vn"));
    }

    @AfterTest
    public void teardown(){
        driver.close();
    }
}
