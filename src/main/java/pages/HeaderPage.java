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
    public  void logoButtonClick(){
        driver.findElement(By.xpath("//img[@alt='site-logo']")).click();
    }


    private final String trackingButton = "//a[contains(text(),'Трекінг')]";
    @FindBy(xpath = trackingButton)
    private WebElement trackingButtonHeader;
    /**
     * Get 'tracking button'
     *
     * @return {@link WebElement}
     */
    public WebElement getTrackingButtonHeader(){
        return trackingButtonHeader;
    }

    private final String serviceOnline = "//h2[contains(.,'Онлайн-сервіси Укрпошти')]";
    @FindBy(xpath = serviceOnline)
    private WebElement serviceOnlineA;
    /**
     * Get 'Service' block
     *
     * @return {@link WebElement}
     */
    public WebElement getServiceOnlineA(){
        return serviceOnlineA;
    }

    private final String logo = "//img[@alt='site-logo']";
    @FindBy(xpath = logo)
    private WebElement logoMain;
    /**
     * Get 'logo' on main page
     *
     * @return {@link WebElement}
     */
    public WebElement getLogoMain(){
        return logoMain;
    }

    private final String reg = "//span[contains(.,'Реєстрація')]";
    @FindBy(xpath = reg)
    private WebElement regi;
    /**
     * Get 'registration' button on main
     *
     * @return {@link WebElement}
     */
    public WebElement getRegi(){
        return regi;
    }

    private final String login = "//span[contains(.,'Вхід /')]";
    @FindBy(xpath = login)
    private WebElement loginButton;
    /**
     * Get 'login' button
     *
     * @return {@link WebElement}
     */
    public WebElement getLoginButton(){
        return loginButton;
    }
    private final String lang = "//span[@id='language-menu-trigger-header']";
    @FindBy(xpath = lang)
    private WebElement langBut;
    /**
     * Get 'language' button to change language
     *
     * @return {@link WebElement}
     */
    public WebElement getLangBut(){
        return langBut;
    }

    private final String eng = "//a[contains(text(),'EN')]";
    @FindBy(xpath = eng)
    private WebElement engBut;
    /**
     * Get 'en' button
     *
     * @return {@link WebElement}
     */
    public WebElement getEngBut(){
        return engBut;
    }
    private final String track = "//span[contains(.,'Track')]";
    @FindBy(xpath = track)
    private WebElement trackMain;
    /**
     * Get 'Tracking' button on main page
     *
     * @return {@link WebElement}
     */
    public WebElement getTrackMain(){
        return trackMain;
    }
    private final String trackButton = "//button[@id='trackbutton']/span";
    @FindBy(xpath = track)
    private WebElement trackButtonT;
    /**
     * Get 'Tracking' button
     *
     * @return {@link WebElement}
     */
    public WebElement getTrackButtonT(){
        return trackButtonT;
    }


}
