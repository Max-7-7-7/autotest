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
    private static WebDriver driver = null;


    public static WebDriver getDriver(String name) {
        if (Objects.isNull(driver) || Optional.of((RemoteWebDriver) driver).get().getSessionId() == null) {
            if ("FIREFOX".equalsIgnoreCase(name)) {
                System.setProperty("webdriver.gecko.driver", "src/main/resources/chromedriver.exe");
                driver = new FirefoxDriver();
            } else if ("CHROME".equalsIgnoreCase(name)) {
                System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
                driver = new ChromeDriver();
            } else {
                System.out.println("We can't instantiate browser");
            }
        }
        if (driver != null) {
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICITLY_WAITER));
            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(IMPLICITLY_WAITER));
        }
        return driver;
    }
}
