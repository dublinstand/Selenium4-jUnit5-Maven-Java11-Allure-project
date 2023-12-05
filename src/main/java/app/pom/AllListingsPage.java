package app.pom;

import io.qameta.allure.Step;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;

import static framework.WaitMethods.waitForElementToBeClickable;

public class AllListingsPage extends BasePage {
    private final By allListingsLabel = By.xpath("//span[contains(text(),'All')]/span");
    private final By allListingOnScreenElements = By.xpath("//div[contains(@class,'sc-jffHpj ewTIhF')]");

    public AllListingsPage(WebDriver driver) {
        super(driver);
    }

    @Step("Navigating to All Listings Page")
    public AllListingsPage navigate() {
        driver.get(BASE_URL + ALL_LISTINGS_PAGE);
        waitForElementToBeClickable(driver, allListingsLabel, EXPLICIT_WAIT);

        return this;
    }

    @Step("Scrolling to the bottom of the page")
    public AllListingsPage scrollDownToBottom() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        try {
            long lastHeight = ((Number) js.executeScript("return document.body.scrollHeight")).longValue();
            while (true) {
                ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight);");
                Thread.sleep(2000);

                long newHeight = ((Number) js.executeScript("return document.body.scrollHeight")).longValue();
                if (newHeight == lastHeight) {
                    break;
                }
                lastHeight = newHeight;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this;
    }

    @Step("Verifying Count for the Listings on the screen label is the same as listings present on screen")
    public boolean verifyListingsOnScreenComparedToAllFieldValue() {
        String listingLabelCount =
                driver.findElement(this.allListingsLabel)
                        .getText()
                        .replace("(", "")
                        .replace(")", "");

        int onScreenListingsCount =
                driver.findElements(this.allListingOnScreenElements)
                        .size();

        return listingLabelCount.equals(String.valueOf(onScreenListingsCount));
    }


}
