package test;

import com.paulhammant.ngwebdriver.ByAngularModel;
import com.paulhammant.ngwebdriver.NgWebDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class discount {
    WebDriver driver;

    @BeforeTest
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\dev\\Web Driver\\chromedriver_win32_ver99\\chromedriver.exe");
        driver = new ChromeDriver();
//        NgWebDriver ngWebDriver;
//        JavascriptExecutor jsDriver;
        driver.get("http://95.111.196.180");
        driver.manage().window().maximize();

    }

    @Test
    public void test1() {
        try {
            WebElement itemName = driver.findElement(By.xpath("//a[@class='featured-product-link']"));
            itemName.click();
            Thread.sleep(500);

            WebElement color = driver.findElement(By.xpath("//img[@title='Navy']"));
            color.click();
            Thread.sleep(500);

            WebElement printLocation = driver.findElement(By.xpath("//label[@for='toggle_print_back']"));
            printLocation.click();
            Thread.sleep(500);

            WebElement buttonAddToCart = driver.findElement(By.xpath("//button[@name='button']"));
            buttonAddToCart.click();
            Thread.sleep(5000);

            WebElement checkout1 = driver.findElement(By.xpath("//a[@class='button checkout-button']"));
            checkout1.click();
            Thread.sleep(2000);

            WebElement quantity = driver.findElement(By.xpath("//input[@class='quantity shopcart-input number-input ng-pristine ng-untouched ng-valid ng-not-empty']"));
            quantity.clear();
            quantity.sendKeys("10");
            Thread.sleep(3000);

            WebElement checkout2 = driver.findElement(By.xpath("//a[@class='button btn-to-checkout flex-box align-c flex-c']"));
            checkout2.click();
            WebDriverWait wait = new WebDriverWait(driver,30);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='js-click-show-promotion subtotal-item flex-box flex-s align-c']//*[name()='svg']")));

            //apply promo code
            WebElement expandIcon = driver.findElement(By.xpath("//div[@class='js-click-show-promotion subtotal-item flex-box flex-s align-c']//*[name()='svg']"));
            expandIcon.click();
            Thread.sleep(500);

            WebElement promoCodeTextBox = driver.findElement(By.xpath("//input[@id='promotion_code']"));
            promoCodeTextBox.sendKeys("%TATCA");
            Thread.sleep(3000);

            WebElement submitPromoCode = driver.findElement(By.xpath("//button[@id='submit_promotion_code']"));
            submitPromoCode.click();
            Thread.sleep(500);

//            Angular project ko nhận vào trường value đâu
//            Nó nhận vào ng- value
//            Thành ra bắt ko dc giá trị

            //nhap thong tin
            driver.findElement(By.xpath("//input[@id='name']")).sendKeys("test1");
            Thread.sleep(500);
            driver.findElement(By.xpath("//input[@id='phone']")).sendKeys("0948123529");
            Thread.sleep(500);
            driver.findElement(By.xpath("//input[@id='email']")).sendKeys("nguyenthanhtinh97@gmail.com");
            Thread.sleep(500);
            driver.findElement(By.xpath("(//input[@id='address'])[1]")).sendKeys("LVL");
            Thread.sleep(500);
            driver.findElement(By.cssSelector("#city_name")).sendKeys("HN");
            Thread.sleep(500);
            driver.findElement(By.xpath("(//input[@id='zipcode'])[1]")).sendKeys("100000");
            Thread.sleep(500);


            //nhap the

//            String frame = "__privateStripeFrame4635";
            driver.switchTo().frame(0);
            WebElement cardNumber = driver.findElement(By.xpath("//body//span[@data-max='4242 4242 4242 4242 4240']//input[@name='cardnumber']"));
            cardNumber.clear();
            cardNumber.sendKeys("4242 4242 4242 4242");
            driver.switchTo().parentFrame();

            driver.switchTo().frame(1);
            WebElement expireDate = driver.findElement(By.xpath("//body//span[@data-max='MM / YY0']//input[@name='exp-date']"));
            expireDate.clear();
            expireDate.sendKeys("04/24");
            driver.switchTo().parentFrame();

            driver.switchTo().frame(2);
            WebElement cvc = driver.findElement(By.xpath("//body//span[@data-max='00000']//input[@name='cvc']"));
            cvc.clear();
            cvc.sendKeys("4242");
            driver.switchTo().parentFrame();

//            WebElement statusApply = driver.findElement(By.xpath("//span[@id='success-promotion']"));
//            Assert.assertEquals(statusApply.getText(),"Apply code successfully!");

            WebElement proceedToPayment = driver.findElement((By.xpath("//a[@class='shopcart-checkout-btn ng-scope']")));
            proceedToPayment.click();
            Thread.sleep(10000);

            WebElement orderSuccess = driver.findElement(By.xpath("//span[contains(text(),'Thank you for your purchase at Printerval')]"));
            Assert.assertEquals(orderSuccess.getText(),"Thank you for your purchase at Printerval");

        } catch (Exception e) {
            System.out.println("run failed");
        }
    }

    @AfterTest
    public void teardown() {
        driver.close();
    }
}
