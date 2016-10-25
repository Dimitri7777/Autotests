package ru.team.infotech;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import com.codeborne.selenide.Configuration;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.open;

public class OEK_Web_Selenium_Tests {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\Documents\\Eclipse Files\\Libraries\\chromedriver.exe");
    // Configuration.browser = "chrome";
    driver = new ChromeDriver();
    baseUrl = "http://frontend.infotech.team/";
  }

  public void LogInSelenium(){

    driver.get(baseUrl);
    driver.findElement(By.id("qa-uname-input")).clear();
    driver.findElement(By.id("qa-uname-input")).sendKeys("png@infotech.team");
    driver.findElement(By.id("qa-password-input")).clear();
    driver.findElement(By.id("qa-password-input")).sendKeys("password");
    driver.findElement(By.xpath(".//*[@id='root']/div/div/div[4]/div[2]/div/div[2]/form/label")).click();
    driver.findElement(By.id("qa-login-button")).click();

  }

  @Test
  public void testOEKSeleniumLogin() throws Exception {
      // Test if user can login
    LogInSelenium();
  }

  @Test
  public void testGoThroughUpperTabs() {
    // Test if user can navigate through upper tabs
    LogInSelenium();

      driver.get(baseUrl);
      driver.findElement(By.xpath("//div[@id='root']/div/div/div[3]/div/div/div/ul/li[2]")).click();
      driver.findElement(By.xpath("//div[@id='root']/div/div/div[3]/div/div/div/ul/li[3]")).click();
      driver.findElement(By.xpath("//div[@id='root']/div/div/div[3]/div/div/div/ul/li[4]")).click();
      driver.findElement(By.xpath("//div[@id='root']/div/div/div[3]/div/div/div/ul/li[5]")).click();
   }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
