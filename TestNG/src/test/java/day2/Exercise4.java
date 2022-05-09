package day2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Exercise4 {
    WebDriver driver;

    @BeforeTest
    public void setup(){
        System.setProperty("webdriver.ie.driver","C:\\dev\\Web Driver\\IEDriverServer_x64_3.150.2\\IEDriverServer.exe");
        driver = new InternetExplorerDriver();
        driver.get("https://lazada.vn/");

    }

    @Test
    public void test(){
        System.out.println("This test verifies title of amazon.com");
        String title = driver.getTitle();
        System.out.println("Title is: " + title);
        Assert.assertTrue(title.contains("LAZADA"));
    }

    @AfterTest
    public void teardown(){
        driver.close();
    }
}
