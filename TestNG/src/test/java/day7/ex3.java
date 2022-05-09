//package day7;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.phantomjs.PhantomJSDriver;
//import org.openqa.selenium.phantomjs.PhantomJSDriverService;
//import org.openqa.selenium.remote.DesiredCapabilities;
//import org.openqa.selenium.support.ui.Select;
//import org.testng.Assert;
//import org.testng.annotations.AfterTest;
//import org.testng.annotations.BeforeTest;
//import org.testng.annotations.Test;
//
//import java.util.concurrent.TimeUnit;
//
//public class ex3 {
//    WebDriver driver;
//
//    @BeforeTest
//    public void beforeTest() {
//        DesiredCapabilities caps = new DesiredCapabilities();
//        caps.setJavascriptEnabled(true); // not really needed: JS enabled by default
//        caps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, "D:\\Auto_Test\\code_java_linksetup\\phantomjs-2.1.1-windows\\bin\\phantomjs.exe");
//        driver = new PhantomJSDriver(caps);
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//    }
//
//    @Test
//    public void TestContacUs() throws InterruptedException {
//        driver.navigate().to("http://automationpractice.com/index.php?controller=contact");
//        WebElement subjectHeading = driver.findElement(By.xpath("//label[normalize-space()='Subject Heading']"));
//        WebElement emailAddress = driver.findElement(By.xpath("//label[normalize-space()='Email address']"));
//        WebElement orderRefference = driver.findElement(By.xpath("//label[normalize-space()='Order reference']"));
//        WebElement attachFile = driver.findElement(By.xpath("//label[normalize-space()='Attach File']"));
//        WebElement message = driver.findElement(By.xpath("//label[normalize-space()='Message']"));
//        WebElement send = driver.findElement(By.xpath("//span[normalize-space()='Send']"));
//
//        Assert.assertTrue(subjectHeading.isDisplayed() || emailAddress.isDisplayed() ||
//                orderRefference.isDisplayed() || attachFile.isDisplayed() || message.isDisplayed() || send.isDisplayed());
//        Select choose = new Select(driver.findElement(By.id("id_contact")));
//        choose.selectByVisibleText("Customer service");
//        Thread.sleep(1000);
//        WebElement emailInput = driver.findElement(By.xpath("//label[@for='email']/following-sibling::input"));
//        emailInput.sendKeys("dong123@gmail.com");
//        Thread.sleep(1000);
//        driver.findElement(By.xpath("//label[contains(.,'Order reference')]/following-sibling::input")).click();
//        WebElement messageInput = driver.findElement(By.xpath("//textarea[@id='message']"));
//        messageInput.sendKeys("Alo 1234 Alo Alo");
//        driver.findElement(By.xpath("//span[normalize-space()='Send']")).click();
//        driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
//        WebElement success = driver.findElement(By.xpath("//div[@id='center_column']//following-sibling::p"));
//        System.out.println(success.getText());
//        Assert.assertEquals("Your message has been successfully sent to our team." ,success.getText());
//
//    }
//    @AfterTest
//    public void afterClass() {
//        driver.quit();
//    }
//}
