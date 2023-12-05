package framework;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;


public class WaitMethods {

    public static void waitForElementToBeClickable(WebDriver driver, final By locator,
                                                         Duration timeout) {
        WebLog.info(String.format("Explicitly waiting for " + timeout + " second element to be clickable " + locator));

        try {
            WebDriverWait wait = new WebDriverWait(driver, timeout);
            wait.until(elementToBeClickable(locator));
        } catch (TimeoutException ex) {
            WebLog.error(String.format("Timed out waiting for " + timeout + " seconds for element to be clickable" + locator), ex);
            throw ex;
        }
    }

    public static void waitForElementToBeVisible(WebDriver driver, final By by,
                                                       Duration timeout) {
        WebLog.info(String.format("Explicitly waiting for " + timeout + " seconds for element to be visible" + by));

        try {
            WebDriverWait wait = new WebDriverWait(driver, timeout);
            wait.until(visibilityOfElementLocated(by));
        } catch (TimeoutException ex) {
            WebLog.error(String.format("Timed out waiting for element to be visible" + by), ex);
            throw ex;
        }
    }
}
