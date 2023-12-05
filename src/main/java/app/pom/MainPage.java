package app.pom;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;

import static framework.WaitMethods.waitForElementToBeClickable;

public class MainPage extends BasePage {
    private final By searchButton = By.xpath("//span[contains(text(),'Search')]");

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public MainPage navigate() {
        driver.get(BASE_URL);
        waitForElementToBeClickable(driver, searchButton, EXPLICIT_WAIT);

        return this;
    }

    @Step("Clicking on search field")
    public SearchPage clickSearchField() {
        driver.findElement(searchButton)
                .click();

        return new SearchPage(driver);
    }
}
