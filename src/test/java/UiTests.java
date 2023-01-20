import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.AssertJUnit.assertTrue;

public class UiTests {

    final public void setProperty(){
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
    }


@Test
    public void checkLogo(){
    ChromeDriver driver = new ChromeDriver();
    driver.get("https://www.ukrposhta.ua/ua");
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    driver.findElement(By.xpath("//img[@alt='site-logo']")).click();
    assertTrue(driver.findElement(By.xpath("//h2[contains(.,'Поштові послуги')]")).isDisplayed());
    driver.close();

}



}
