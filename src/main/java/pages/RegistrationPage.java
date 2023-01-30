package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage {

    WebDriver driver;
    public RegistrationPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    private final String sub = "//input[@id='cpsubmit']";
    @FindBy(xpath = sub)
    private WebElement subBut;
    /**
     * Get 'Button to submit form'
     */
    public WebElement getSubBut(){
        return subBut;
    }
    private final String checkBox = "//div[@id='registration-form']/form/div[22]/div[2]/label[2]";
    @FindBy(xpath = checkBox)
    private WebElement checkBoxOne;
    /**
     * Get 'Checkbox'
     */
    public WebElement getCheckBoxOne(){
        return checkBoxOne;
    }
    /**
     * Method to field the registration form
     */
    public void fieldForm(){
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("max@max.max");
        driver.findElement(By.xpath("//input[@id='pass']")).sendKeys("1Qazxcvbnm1");
        driver.findElement(By.xpath("//input[@id='password-confirm']")).sendKeys("1Qazxcvbnm1");
        driver.findElement(By.xpath("//input[@id='lastName']")).sendKeys("Max");
        driver.findElement(By.xpath("//input[@id='firstName']")).sendKeys("Max");
        driver.findElement(By.xpath("//input[@id='middleName']")).sendKeys("Max");
        driver.findElement(By.xpath("//input[@id='latinName']")).sendKeys("Max");
        driver.findElement(By.xpath("//input[@id='index']")).sendKeys("49086");
        driver.findElement(By.xpath("//input[@id='address']")).sendKeys("Бендерівська");
        driver.findElement(By.xpath("//input[@id='housenum']")).sendKeys("14");
        driver.findElement(By.xpath("//input[@id='appartment']")).sendKeys("88");
    }


}
