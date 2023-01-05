import   com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class AutomationTests {


    @Test
    public void checkLogo() {

        Configuration.browserSize = "1920x1080";

        open("https://www.ukrposhta.ua/ua");
        $(By.xpath("//*[@id='top-header']//img")).click();
        $(By.xpath("//*[@id='top-header']//img")).shouldBe(Condition.visible);
    }

    @Test
    public void scrollToElement() {

        Configuration.browserSize = "1920x1080";

        open("https://www.ukrposhta.ua/ua");
        $(By.xpath("(//a[contains(text(),'ukrposhta@ukrposhta.ua')])[2]")).scrollIntoView(false);
        $(By.xpath("//*[@id='top-header']//img")).shouldBe(Condition.visible);
    }

    @Test
    public void findTheIndex() {

        Configuration.browserSize = "1920x1080";

        open("https://www.ukrposhta.ua/ua");
        $(By.xpath("//h2[contains(.,'Новини')]")).scrollIntoView(false);
        $(By.xpath("//button[@id='find_index2']")).click();
        $(By.xpath("//input[@id='toWhere']")).setValue("Дніпро");
        $(By.xpath("//button[@id='3641']")).click();
        $(By.xpath("//button[@id='S175741']")).click();
        $(By.xpath("//button[@id='H1']")).click();
        $(By.xpath("//button[@type='submit']")).click();
        $(By.xpath("//p[contains(.,'49086')]")).shouldBe(Condition.visible);

    }

    @Test
    public void scrollToElement1() {

        Configuration.browserSize = "1920x1080";

        open("https://www.ukrposhta.ua/en");
        $(By.xpath("//input[@id='trackcode']")).setValue("1111111111");;
        $(By.xpath("//span[contains(.,'Track')]")).click();
        $(By.xpath("//div/div[2]/div[4]/div")).shouldBe(Condition.visible);
    }

    @Test
    public void checkCalculator() {

        Configuration.browserSize = "1920x1080";

        open("https://www.ukrposhta.ua/ua");
        $(By.xpath("//a[@id='calculate_button']")).click();
        $(By.xpath("//h6[contains(.,'Зверніть, будь ласка, увагу!')]")).shouldBe(Condition.visible);
    }
}
