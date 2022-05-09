package day5;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.awt.Rectangle;
import java.io.IOException;

public class ex2 {
    WebDriver driver;

    @BeforeTest
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\dev\\Web Driver\\chromedriver_win32_ver95\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://demo.guru99.com/test/simple_context_menu.html");

    }

    @Test
    public void test1() throws AWTException, IOException, NoAlertPresentException {

        try {
            WebElement btn = driver.findElement(By.xpath("//button"));
            Assert.assertTrue(btn.isDisplayed());

            Actions act = new Actions(driver);
            //Double click on element
            act.doubleClick(btn).perform();

            Alert alert = driver.switchTo().alert();
            System.out.println(alert.getText());
            Thread.sleep(3000);

            BufferedImage image = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
            ImageIO.write(image, "png", new File("C:\\dev\\TestNG\\src\\test\\java\\day5\\ex2.png"));

            alert.dismiss();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @AfterTest
    public void teardown() {
        driver.close();
    }
}
