package core;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class WebUI {
    static WebDriver driver;

    public static int toNumber(String price) {
        price = price.replace(".", "");
        price = price.replace("đ", "");
        int priceNum = Integer.parseInt(price);
        return priceNum;
    }

    public void sendKeysAfterWait(WebElement element, String value) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(10));
//        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
        wait.until(ExpectedConditions.visibilityOf(element));
        element.clear();
        element.sendKeys(value);
    }

    public void clickElementAfterWait(WebDriver driver, WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(10));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    public void selectDropDownAfterWait(WebElement element, String visibleText) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(10));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
        Select chooseValue = new Select(element);
        chooseValue.selectByVisibleText(visibleText);
    }

//        public void verifyTitle(String expectedTitle){
//        String actualTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(firstProductTitle)).getText();
//        Assert.assertEquals(actualTitle,expectedTitle);
//    }

    public static void sleep(long second) {
        try {
            Thread.sleep(second * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void waitForPageLoaded() {

        // wait for jQuery to loaded
        ExpectedCondition<Boolean> jQueryLoad = driver -> {
            try {
                return ((Long) ((JavascriptExecutor) driver).executeScript("return jQuery.active") == 0);
            } catch (Exception e) {
                return true;
            }
        };

        // wait for Javascript to loaded
        ExpectedCondition<Boolean> jsLoad = driver -> ((JavascriptExecutor) driver).executeScript("return document.readyState")
                .toString().equals("complete");

        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            wait.until(jQueryLoad);
            wait.until(jsLoad);
        } catch (Exception e) {
            System.out.println("Quá thời gian load trang.");
        }
    }

    //Wait for Angular Load
    public void waitForAngularLoad() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        final String angularReadyScript = "return angular.element(document).injector().get('$http').pendingRequests.length === 0";

        //Wait for ANGULAR to load
        ExpectedCondition<Boolean> angularLoad = driver -> {
            try {
                return Boolean.valueOf(((JavascriptExecutor) driver).executeScript(angularReadyScript).toString());
            } catch (Exception e) {
                // no jQuery present
                return true;
            }
        };

        //Get Angular is Ready
        boolean angularReady = Boolean.valueOf(js.executeScript(angularReadyScript).toString());

        //Wait ANGULAR until it is Ready!
        if (!angularReady) {
            System.out.println("ANGULAR is NOT Ready!");
            //Wait for Angular to load
            wait.until(angularLoad);
        } else {
            System.out.println("ANGULAR is Ready!");
        }
    }


}
