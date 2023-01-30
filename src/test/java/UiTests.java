import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pages.helpers.HeaderHelper;
import jdk.jfr.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.*;

import java.time.Duration;

import static org.junit.Assert.assertTrue;
import static utils.Constants.IMPLICITLY_WAITER;
import static utils.WebDriverFactory.getDriver;

public class UiTests {
    HeaderPage headerPage;
    HeaderHelper headerHelper;
    TrackingPage trackingPage;
    WebDriver driver;
    WebDriverWait wait;
    LoginPage loginPage;
    RegistrationPage registrationPage;

    @Before
    public void setProperty() {

        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = getDriver("CHROME");
        headerPage = new HeaderPage(driver);
        trackingPage = new TrackingPage(driver);
        headerHelper = new HeaderHelper(driver);
        loginPage = new LoginPage(driver);
        registrationPage = new RegistrationPage(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(IMPLICITLY_WAITER));
        driver.manage().window().maximize();

        driver.get("https://www.ukrposhta.ua/ua");
    }

    @After
    public void after() {
        driver.quit();
    }


    @Test
    @Description(value = "Check 'Лого' button")
    public void checkLogo(){//work

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//img[@alt='site-logo']")));
        headerHelper.clickAndWaitJs(headerPage.getLogoMain(), "c");
        assertTrue(driver.findElement(By.xpath("//h2[contains(.,'Поштові послуги')]")).isDisplayed());

    }

    @Test
    @Description(value = "Check alert")
    public void trackingButt(){

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"top-header\"]/div/div/a/img")));

        headerHelper.clickAndWaitJs(headerPage.getLangBut(), "C");
        headerHelper.clickAndWaitJs(headerPage.getEngBut(), "C");

        driver.findElement(By.xpath("//input[@id='trackcode']")).sendKeys("1234569874");
        headerHelper.clickAndWaitJs(headerPage.getTrackMain(), "C");

        assert (driver.findElement(By.xpath("//h6[contains(.,'How to use it?')]")).isDisplayed());
    }


    @Test
    @Description(value = "Move to element")
    public void checkOnlineService(){//work
        Actions action = new Actions(driver);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@alt='site-logo']")));
        WebElement onlineService = headerPage.getServiceOnlineA();
        action.moveToElement(onlineService);
        assertTrue(driver.findElement(By.xpath("//h2[contains(.,'Онлайн-сервіси Укрпошти')]")).isDisplayed());

    }
    @Test
    @Description(value = "Move to element")
    public void fieldFormError()  {//work

        headerHelper.clickAndWaitJs(headerPage.getRegi(), "Click on registration button");
        registrationPage.fieldForm();
        headerHelper.clickAndWaitJs(registrationPage.getCheckBoxOne(), "C");
        headerHelper.clickAndWaitJs(registrationPage.getSubBut(), "C");
        assertTrue(driver.findElement(By.xpath("//div[@id='error-masseg']")).isDisplayed());

    }

    @Test
    @Description(value = "Change language")
    public void changeLanguage(){ //work

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"top-header\"]/div/div/a/img")));

        headerHelper.clickAndWaitJs(headerPage.getLangBut(), "C");
        headerHelper.clickAndWaitJs(headerPage.getEngBut(), "C");

        assertTrue(driver.findElement(By.xpath("//h2[contains(.,'Postal services')]")).isDisplayed());

    }

}
