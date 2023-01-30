package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TrackingPage {
        public TrackingPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    private final String trackingField = "//div[@id='printable-content']/div/form/div/input";
    @FindBy(xpath = trackingField)
    private WebElement trackingFieldF;
    /**
     * Get 'Field to track number'
     */
    public WebElement getTrackingFieldF(){
        return trackingFieldF;
    }

    private final String trackingFieldButton = "//*[@id=\"trackbutton\"]/span[1]";
    @FindBy(xpath = trackingFieldButton)
    private WebElement trackingFieldB;
    /**
     * Get 'Button to track number'
     */
    public WebElement getTrackingFieldButton(){
        return trackingFieldB;
    }

}
