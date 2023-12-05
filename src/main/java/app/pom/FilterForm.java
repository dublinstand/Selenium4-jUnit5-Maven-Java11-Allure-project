package app.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static framework.WaitMethods.waitForElementToBeVisible;

public class FilterForm extends BasePage {

    private final By applyButton = By.xpath("//span[contains(text(),'Apply')]");
    private final By fromPrice = By.xpath("//input[contains(@placeholder, 'From')]");

    private final By toPrice = By.xpath("//input[contains(@placeholder, 'To')]");

    private final By roomsAndBedsButtons = By.xpath("//button[contains(@class, 'sc-flUlpA sc-iGkqmO eEVTIr ckwDLe')]");
    private final By amenitiesCheckBoxes = By.xpath("//label[contains(@class, 'sc-gVFcvn jrzUMQ')]");
    private final By clearAll = By.xpath("//b[contains(text(), 'Clear all')]");


    public FilterForm(WebDriver driver) {
        super(driver);
    }

    public FilterForm onFilterPage() {
        waitForElementToBeVisible(driver, applyButton, EXPLICIT_WAIT);
        return this;
    }

    public FilterForm fillAllFieldsUseRoomsAndBedsCheckAllBoxes(String fromPrice, String toPrice) {
        driver.findElement(this.fromPrice)
                .sendKeys(fromPrice);
        driver.findElement(this.toPrice)
                .sendKeys(toPrice);

        driver.findElements(this.roomsAndBedsButtons).
                forEach(WebElement::click);

        driver.findElements(this.amenitiesCheckBoxes)
                .forEach(WebElement::click);

        return this;
    }

    public FilterForm clickClearAll(){
        driver.findElement(this.clearAll)
                .click();

        return this;
    }
}
