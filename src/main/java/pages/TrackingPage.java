package pages;

import helpers.HeaderHelper;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TrackingPage {

    HeaderPage headerPage;
    HeaderHelper headerHelper;
    WebDriver driver;

    public TrackingPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    public void sendKeys(WebElement element){
         element.sendKeys("12312423423423412");
    }
    public void click(WebElement element){
        element.click();
    }
    public void clickAndWaitJsTracking(WebElement element, String description) {
        System.out.println(description);
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element);
    }

    private final String trackingField = "//div[@id='printable-content']/div/form/div/input";
    @FindBy(xpath = trackingField)
    private WebElement trackingFieldF;

    public WebElement getTrackingFieldF(){
        return trackingFieldF;
    }

    private final String trackingFieldButton = "//span[contains(.,'Відстежити')]";
    @FindBy(xpath = trackingFieldButton)
    private WebElement trackingFieldB;

    public WebElement getTrackingFieldButton(){
        return trackingFieldB;
    }

}
