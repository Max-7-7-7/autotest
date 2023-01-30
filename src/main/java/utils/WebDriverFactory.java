package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.time.Duration;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

import static java.lang.System.getProperty;
import static utils.Constants.IMPLICITLY_WAITER;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;


public class WebDriverFactory {
    private static final WebDriver driver = null;

    /**
     * {@link WebDriverFactory} return a WebDriver object based on the input name parameter
     *
     * @param name - the name of the browser, can be FIREFOX or CHROME
     * @return driver - the WebDriver object
     */
    public static WebDriver getDriver(String name) {

        switch (name) {
            case "FIREFOX" -> {
                System.setProperty("webdriver.gecko.driver", "src/main/resources/chromedriver.exe");
                return new FirefoxDriver();
            }
            case "CHROME" -> {
                System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
                return new ChromeDriver();
            }
            default -> System.out.println("We can't initiate the browser");
        }


        return driver;
    }
}
