package framework;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.TimeoutException;

public class WebLog {
    private static final Logger LOGGER = LogManager.getLogger(WebLog.class);

    public static void info(String message) {
        LOGGER.info(message);
    }

    public static void error(String message, TimeoutException ex) {
        LOGGER.error(message);
    }

}
