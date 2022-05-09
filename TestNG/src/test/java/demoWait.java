import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class demoWait {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\dev\\Web Driver\\chromedriver_win32_ver99\\chromedriver.exe");

        // Start browser
        WebDriver driver = new ChromeDriver();

        // Start application
        driver.get("http://seleniumpractise.blogspot.in/2016/08/how-to-use-explicit-wait-in-selenium.html");

        // Click on timer button to start
        driver.findElement(By.xpath("//button[text()='Click me to start timer']")).click();

        // Create object of WebDriverWait class and it will wait max of 20 seconds.
        // By default it will accepts in Seconds
        WebDriverWait wait = new WebDriverWait(driver, 20);

        // Here we will wait until element is not visible, if element is visible then it will return web element
        // or else it will throw exception
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()='Selenium']")));

        // if element found then we will use- In this example I just called isDisplayed method
        boolean status = element.isDisplayed();

        // if else condition
        if (status) {
            System.out.println("===== Selenium is visible======");
        } else {
            System.out.println("===== Selenium is not visible======");
        }

    }
}
