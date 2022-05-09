package day5;

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
        driver.get("http://demo.guru99.com/test/simple_context_menu.html");

    }

    @Test
    public void test1() throws AWTException, IOException, NoAlertPresentException {

        try {
            WebElement rightClick = driver.findElement(By.xpath("//span[@class='context-menu-one btn btn-neutral']"));
            Assert.assertTrue(rightClick.isDisplayed());;

            Actions act = new Actions(driver);
            //right click on element
            act.contextClick(rightClick).perform();
            Thread.sleep(2000);


            WebElement edit = driver.findElement(By.xpath("//ul[@class='context-menu-list context-menu-root']//descendant::li[1]//descendant::span"));
            edit.click();

            Alert alert = driver.switchTo().alert();
            System.out.println(alert.getText());
            Thread.sleep(3000);

            BufferedImage image = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
            ImageIO.write(image, "png", new File("C:\\dev\\TestNG\\src\\test\\java\\day5\\ex3.png"));

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
