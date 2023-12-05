package app.pom;

import org.openqa.selenium.WebDriver;

import app.AppConfig;

import java.time.Duration;

public abstract class BasePage {
    public static final String BASE_URL = AppConfig.BASE_URL;
    public static final String ALL_LISTINGS_PAGE = AppConfig.ALL_LISTINGS_PAGE;

    public static final Duration EXPLICIT_WAIT = Duration.ofSeconds(AppConfig.STANDARD_EXPLICIT_WAIT_SECONDS);
    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }
}
