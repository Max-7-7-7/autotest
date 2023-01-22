import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.AssertJUnit.assertTrue;

public class UiTests {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeMethod
    public void setProperty() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

        driver = new ChromeDriver();
        driver.get("https://www.ukrposhta.ua/ua");
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void after() {
        driver.quit();
    }


    @Test
    public void checkLogo() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//img[@alt='site-logo']")));

        try {
            driver.findElement(By.xpath("//img[@alt='site-logo']")).click();
        } catch (Exception e) {
            JavascriptExecutor ex = (JavascriptExecutor) driver;
            ex.executeScript("arguments[0].click();", driver.findElement(By.xpath("//img[@alt='site-logo']")).click());
        }
        assertTrue(driver.findElement(By.xpath("//h2[contains(.,'Поштові послуги')]")).isDisplayed());

    }


}
