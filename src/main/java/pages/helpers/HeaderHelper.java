package pages.helpers;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import pages.TrackingPage;

public class HeaderHelper extends BaseHelper{

    WebDriver driver;
    TrackingPage trackingPage;

    public HeaderHelper(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;

    }

    public void click(WebElement element){
        element.click();
    }
    /**
     * Script to wait element
     */
    public void clickAndWaitJs(WebElement element, String description) {
        System.out.println(description);
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element);
    }




}
