package phantomjs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;


public class test {
    public static void main(String[] args) {
        WebDriver driver;
        System.setProperty("webdriver.chrome.driver", "C:\\dev\\Web Driver\\chromedriver_win32_ver99\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://chiaki.local.vn/don-hang?token=bYHIaiWKhkJJuaUns%2Bk7PGoEh7fLgCoKsNBqEFYPZPk%3D&customerCode=C6F9");

//        driver.findElement(By.linkText("R02005657")).click();
        driver.findElement(By.xpath("(//td[@class='order-code']//a)[1]")).click();
//        DesiredCapabilities caps = new DesiredCapabilities();
//        caps.setJavascriptEnabled(true);
//        caps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, "C:\\dev\\phantomjs\\bin\\phantomjs.exe"");
//
//        WebDriver driver = new PhantomJSDriver(caps);


    }
}
