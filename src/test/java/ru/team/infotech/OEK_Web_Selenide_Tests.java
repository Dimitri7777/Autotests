package ru.team.infotech;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Configuration;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.open;


public class OEK_Web_Selenide_Tests {

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\Documents\\Eclipse Files\\Libraries\\chromedriver.exe");
        Configuration.browser = "chrome";
    }


    public void LogIn(){
        open("http://frontend.infotech.team/");
        $("#qa-uname-input").sendKeys("png@infotech.team");
        $("#qa-uname-input").pressTab();
        $(By.xpath(".//*[@id='qa-password-input']")).sendKeys("password");
        $(By.xpath((".//*[@id='root']/div/div/div[4]/div[2]/div/div[2]/form/label"))).click();
        $(By.xpath(".//*[@id='qa-login-button']")).click();
    }

    @Test
    public void LoginTest() {
        // Test if user can login
        LogIn();

    }

    @Test
    public void GoThgoughUpperTabsTest() {
        // Test if user can navigate through upper tabs
        LogIn();

        $(By.xpath(".//*[@id='root']/div/div/div[3]/div/div[1]/div/ul[1]/li[1]")).click();
        $(By.xpath(".//*[@id='root']/div/div/div[3]/div/div[1]/div/ul[1]/li[2]")).click();
        $(By.xpath(".//*[@id='root']/div/div/div[3]/div/div[1]/div/ul[1]/li[3]")).click();
        $(By.xpath(".//*[@id='root']/div/div/div[3]/div/div[1]/div/ul[1]/li[4]")).click();
        $(By.xpath(".//*[@id='root']/div/div/div[3]/div/div[1]/div/ul[1]/li[6]")).click();

        $(By.xpath(".//*[@id='root']/div/div/div[3]/div/div[1]/div/ul[1]/li[3]")).click();
        $(By.xpath(".//*[@id='root']/div/div/div[3]/div/div[1]/div/ul[1]/li[1]")).click();

    }

    @Test
    public void CreateIssueTest(){
        LogIn();

        $(By.xpath(".//*[@id='root']/div/div/div[3]/div/div[1]/div/div/a[1]")).click();
        $(By.id("rw_127__listbox__option__4")).selectOption("Заявка по КСЭД");






    }


}