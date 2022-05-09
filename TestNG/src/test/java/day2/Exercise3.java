package day2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Exercise3 {
    WebDriver driver;

    @BeforeTest
    public void setup(){
        System.setProperty("webdriver.gecko.driver","C:\\dev\\Web Driver\\geckodriver-v0.30.0-win64\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.get("https://amazon.com/");

    }

    @Test
    public void test(){
        System.out.println("This test verifies title of amazon.com");
        String title = driver.getTitle();
        System.out.println("Title is: " + title);
        Assert.assertTrue(title.contains("amazon.com"));
    }

    @AfterTest
    public void teardown(){
        driver.close();
    }
}
