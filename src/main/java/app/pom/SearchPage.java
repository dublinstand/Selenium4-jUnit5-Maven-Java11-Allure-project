package app.pom;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;

import static framework.WaitMethods.waitForElementToBeVisible;

public class SearchPage extends BasePage {
    private final By filterButton = By.xpath("//span[contains(text(),'Filter')]");
    private final By checkInDate = By.xpath("//div[contains(text(),'Check-in')]");
    private final By rightArrowInDate = By.xpath("(//button[contains(@class, 'sc-giAqHp iDV')])[2]");

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    @Step("Verified we are on Search Page")
    public SearchPage onSearchPage() {
        waitForElementToBeVisible(driver, this.filterButton, EXPLICIT_WAIT);

        return this;
    }

    public FilterForm clickOnFilterButton() {
        driver.findElement(this.filterButton)
                .click();

        return new FilterForm(driver);
    }

    @Step("Entering amount for From Date {0} and To Date {1} and checking all checkboxes")
    public FilterForm enterBookingDates(String fromDate, String toDate) {
        driver.findElement(checkInDate).click();

        waitForElementToBeVisible(driver, this.rightArrowInDate, EXPLICIT_WAIT);
        driver.findElement(this.rightArrowInDate).click();

        driver.findElement(By.xpath("//div[contains(@class, 'sc-biJonm gBUQwF CalendarDay') and text() = '" + fromDate + "']"))
                .click();
        driver.findElement(By.xpath("(//div[contains(@class, 'sc-biJonm gBUQwF CalendarDay') and text() = '" + toDate + "'])[2]"))
                .click();

        return clickOnFilterButton();
    }

}
