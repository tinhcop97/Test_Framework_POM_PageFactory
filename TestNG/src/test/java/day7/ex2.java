//package day7;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.phantomjs.PhantomJSDriver;
//import org.openqa.selenium.phantomjs.PhantomJSDriverService;
//import org.openqa.selenium.remote.DesiredCapabilities;
//import org.testng.Assert;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeTest;
//import org.testng.annotations.Test;
//
//public class ex2 {
//    @BeforeTest
//    public void setup(){
//        DesiredCapabilities caps = new DesiredCapabilities();
//        caps.setJavascriptEnabled(true); // not really needed: JS enabled by default
//        caps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, "C:\\dev\\phantomjs\\bin\\phantomjs.exe");
//        WebDriver driver = new PhantomJSDriver(caps);
//    }
//    @Test
//    public void test(){
//        getDriver().navigate().to("http://www.google.com");
//        String strPageTitle = getDriver().getTitle();
//        Assert.assertTrue(strPageTitle.equalsIgnoreCase("Google"), "Page title doesn't match");
//    }
//    @Test
//    public void testSearchGoogle() {
//        System.out.println("Opening Google..");
//        getDriver().navigate().to("http://www.google.com");
//        getDriver().findElement(By.name("q")).sendKeys("Selenium Easy Grid Tutorials");
//        getDriver().findElement(By.name("q")).submit();
//    }
//    @AfterClass
//    public void afterClass() {
//        driver.quit();
//    }
//}
