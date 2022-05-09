package day3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ex1 {
    WebDriver driver;

    @BeforeTest
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\dev\\Web Driver\\chromedriver_win32_ver97\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.walmart.com/account/signup");
        driver.manage().window().maximize();

    }

    @Test
    public void test1() {
//        Write the selectors of element by Id, Name, Class, XPath as below:
//        -First Name Text Box
//        -Last Name Text Box
//        -Email Address Text Box
//        -Create a Password Text Box
//        -Keep me signed in check box
//        -Create Account Button
//        -Sign in Button

        try{
//            WebElement firstName = driver.findElement(By.id("first-name-su"));
//            WebElement firstName = driver.findElement(By.name("firstName"));
            WebElement firstName = driver.findElement(By.xpath("(//input[@id='first-name-su'])[1]"));
            firstName.sendKeys("Tinh");
            Thread.sleep(1000);

//            WebElement lastName = driver.findElement(By.id("last-name-su"));
//            WebElement lastName = driver.findElement(By.name("lastName"));
            WebElement lastName = driver.findElement(By.xpath("(//input[@id='last-name-su'])[1]"));
            lastName.sendKeys("Nguyen");
            Thread.sleep(1000);

//            WebElement email = driver.findElement(By.id("email-su"));
//            WebElement email = driver.findElement(By.name("email"));
            WebElement email = driver.findElement(By.xpath("(//input[@id='email-su'])[1]"));
            email.sendKeys("tinhnt20@gmail.com");
            Thread.sleep(1000);

//            WebElement pass = driver.findElement(By.id("password-su"));
//            WebElement pass = driver.findElement(By.name("password"));
            WebElement pass = driver.findElement(By.xpath("(//input[@id='password-su'])[1]"));
            pass.sendKeys("123456789Abc");
            Thread.sleep(1000);

            WebElement keepMe = driver.findElement(By.xpath("//input[@id='remember-me-su']//following-sibling::label"));
            keepMe.click();
            System.out.println(keepMe.isSelected());
            Thread.sleep(1000);

            WebElement create = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/form[2]/button[1]"));
            create.click();
            Thread.sleep(3000);

            WebElement signIn = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/form[2]/button[2]"));


        } catch (Exception e){
            System.out.println("can't find");
        }
    }

    @AfterTest
    public void teardown() {
        driver.close();
    }
}
