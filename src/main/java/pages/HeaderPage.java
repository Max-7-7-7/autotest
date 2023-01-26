package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HeaderPage extends BasePage {

    WebDriver driver;

    public HeaderPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;

    }


    private final String trackingButton = "//a[contains(text(),'Трекінг')]";


    @FindBy(xpath = trackingButton)
    private WebElement trackingButtonHeader;

    public WebElement getTrackingButtonHeader(){
        return trackingButtonHeader;
    }


}
