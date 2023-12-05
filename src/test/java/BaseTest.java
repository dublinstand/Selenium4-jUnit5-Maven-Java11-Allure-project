import app.pom.AllListingsPage;
import app.pom.FilterForm;
import app.pom.MainPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.openqa.selenium.WebDriver;
import utils.TestListener;
import utils.WebDriverFactory;


@ExtendWith(TestListener.class)
@Execution(ExecutionMode.CONCURRENT)
public class BaseTest {

    public MainPage mainPage;
    public FilterForm filterForm;
    public AllListingsPage allListingsPage;
    public final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    @BeforeEach
    public void initDriver() {
        driver.set(WebDriverFactory.getWebDriver());
        mainPage = new MainPage(getDriver());
        filterForm = new FilterForm(getDriver());
        allListingsPage = new AllListingsPage(getDriver());
    }

    @BeforeAll
    public static void driverSetup()  {
        switch (WebDriverFactory.BROWSER_TYPE) {
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                break;
            case "chrome":
            default:
                WebDriverManager.chromedriver().setup();
        }
    }
    protected  WebDriver getDriver() {
        return driver.get();
    }

}
