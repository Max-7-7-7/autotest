import helpers.HeaderHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HeaderPage;
import pages.TrackingPage;

import java.time.Duration;
import static org.testng.AssertJUnit.assertTrue;
import static pages.BasePage.logoButton;
import static utils.Constants.IMPLICITLY_WAITER;
import static utils.WebDriverFactory.getDriver;

public class UiTests {
    HeaderPage headerPage;
    HeaderHelper headerHelper;
    TrackingPage trackingPage;
    WebDriver driver;
    WebDriverWait wait;

    @BeforeMethod
    public void setProperty() {

        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = getDriver("CHROME");
        headerPage = new HeaderPage(driver);
        trackingPage = new TrackingPage(driver);
        headerHelper = new HeaderHelper(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(IMPLICITLY_WAITER));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICITLY_WAITER));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(IMPLICITLY_WAITER));
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void after() {
        driver.quit();
    }


    @Test
    public void checkLogo() {

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//img[@alt='site-logo']")));
        driver.findElement(logoButton).click();

//        try {
//            driver.findElement(By.xpath("//img[@alt='site-logo']")).click();
//        } catch (Exception e) {
//            JavascriptExecutor ex = (JavascriptExecutor) driver;
//            ex.executeScript("arguments[0].click();", driver.findElement(By.xpath("//img[@alt='site-logo']")));
//        }
        assertTrue(driver.findElement(By.xpath("//h2[contains(.,'Поштові послуги')]")).isDisplayed());

    }
    @Test
    public void trackingButt() throws InterruptedException {
        driver.get("https://www.ukrposhta.ua/ua");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@alt='site-logo']")));

//        headerHelper.clickAndWaitJs(headerPage.getTrackingButtonHeader(), "Ckick on tracking button");
//        trackingPage.getTrackingFieldF().sendKeys("jopa");
//        headerHelper.clickAndWaitJs(trackingPage.getTrackingFieldButton(), "Click on tracking button");
        jopa2(headerPage.getTrackingButtonHeader(), trackingPage.getTrackingFieldButton());
        assertTrue(driver.findElement(By.xpath("//*[@id='printable-content']/div/div[2]/div[4]/div")).isDisplayed());
    }

    public void jopa2(WebElement elementHeader, WebElement elementButton) {
        headerHelper.clickAndWaitJs(elementHeader, "Ckick on tracking button"); //headerPage.getTrackingButtonHeader()
        trackingPage.getTrackingFieldF().sendKeys("jopa");
        headerHelper.clickAndWaitJs(elementButton, "Click on tracking button");  //trackingPage.getTrackingFieldButton()
    }

    @Test
    public void checkLogo1() throws InterruptedException {
        driver.get("https://www.ukrposhta.ua/ua");
        Thread.sleep(10000);
        driver.findElement(By.xpath("//*[@id='top-header']//img")).click();
        driver.findElement(By.xpath("//input[@id='trackcode']")).sendKeys("wkdmpow");
    }
//
//    @Test
//    public void scrollToElement()  {
//        driver.findElement(By.xpath("(//a[contains(text(),'ukrposhta@ukrposhta.ua')])[2]")).scrollIntoView(false);
//        driver.findElement(By.xpath("//*[@id='top-header']//img"));
//    }
//
//    @Test
//    public void findTheIndex()  {
//
//        driver.findElement(By.xpath("//h2[contains(.,'Новини')]"));
//        driver.findElement(By.xpath("//button[@id='find_index2']")).click();
//        driver.findElement(By.xpath("//input[@id='toWhere']")).setValue("Дніпро");
//        driver.findElement(By.xpath("//button[@id='3641']")).click();
//        driver.findElement(By.xpath("//button[@id='S175741']")).click();
//        driver.findElement(By.xpath("//button[@id='H1']")).click();
//        driver.findElement(By.xpath("//button[@type='submit']")).click();
//        driver.findElement(By.xpath("//p[contains(.,'49086')]"));
//
//    }
//
//    @Test
//    public void scrollToElement1()  {
//
//        driver.findElement(By.xpath("//input[@id='trackcode']")).setValue("1111111111");;
//        driver.findElement(By.xpath("//span[contains(.,'Track')]")).click();
//        driver.findElement(By.xpath("//div/div[2]/div[4]/div"));
//    }
//
//    @Test
//    public void checkCalculator() throws InterruptedException {
//
//        driver.findElement(By.xpath("//a[@id='calculate_button']")).click();
//        driver.findElement(By.xpath("//h6[contains(.,'Зверніть, будь ласка, увагу!')]"));
//    }
//
//    @Test
//    public void chengeEN() throws InterruptedException {
//
//        driver.findElement(By.xpath("//span[@id='language-menu-trigger-header']")).click();
//        driver.findElement(By.xpath("//a[contains(text(),'EN')]")).click();
//        driver.findElement(By.xpath("//h2[contains(.,'Postal services')]"));
//    }

}
