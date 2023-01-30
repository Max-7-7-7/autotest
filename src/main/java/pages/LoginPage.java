package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    WebDriver driver;
    public LoginPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    private final String username = "//span[@id='login-text']";
    @FindBy(xpath = username)
    private WebElement usernameField;
    /**
     * Get 'Field' to wright username
     */
    public WebElement getUsernameField(){
        return usernameField;
    }
    private final String pasword = "//input[@name='pass-user']";
    @FindBy(xpath = pasword)
    private WebElement paswordField;
    /**
     * Get 'Field' to wright password
     */
    public WebElement getpaswordField(){
        return paswordField;
    }
    private final String vhid = "//span[contains(.,'Вхід /')]";
    @FindBy(xpath = vhid)
    private WebElement vhidButton;
    /**
     * Get 'Button "Vhid"'
     */
    public WebElement getVhidButton(){
        return vhidButton;
    }



}
