package ru.team.infotech;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Configuration;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.open;



public class AutoTests {

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\Documents\\Eclipse Files\\Libraries\\chromedriver.exe");
        Configuration.browser = "chrome";
    }

    @Test
    public void testOne() {

        open("http://infotech.group/");

        $("#header-about").shouldHave(text("О компании"));
        $("#header-about").shouldNotHave(text("О компаниях"));

        $(byLinkText("Контакты")).click();
        $(byText("Казань")).click();

        $(byLinkText("Продукты")).hover();
        $(byLinkText("О компании")).hover();
        $(byLinkText("Продукты")).hover();
        $(byLinkText("О компании")).hover();

        $(byLinkText("Разработчикам")).click();

    }

    @Test
    public void testTwo() {

        open("http://infotech.group/");
        $(byLinkText("О компании")).hover().click();
        $(byLinkText("Направления деятельности")).hover().click();
        $(".btn").click();
        $(".publications-list").findElementByPartialLinkText("Умные города").click();

    }

    @Test
    public void testThree() {

        open("http://infotech.group/");

        $(byLinkText("Продукты")).hover();

        // Перейти на Infotech Industry
       $(byCssSelector(".prod-list>li>object>a>div")).click();

        // Экономические преимущества
       $(byXpath("html/body/div[1]/div/div/div[4]/div/div/ul[1]/li[2]")).click();

    }

    @Test
    public void testFour(){

        open("http://infotech.group/products/complex/infotechindustry");
        // Показать больше решений
        $(byXpath("html/body/div[1]/div/div/div[2]/div/div/p[1]")).click();


    }

    @Test
    public void testFive(){

        open("http://infotech.group/products/perspective/opeka");

        $(byXpath("html/body/div[1]/div/div/div/div/div/div[2]/div")).click();

        // Скачать презентацию
        $(byXpath("html/body/div[1]/div/div/div/div/div/div[3]/a")).click();

        // 3 раза вперед
        $(byXpath("html/body/div[1]/div/div/div/div/div/div[3]/div[3]")).click();
        $(byXpath("html/body/div[1]/div/div/div/div/div/div[3]/div[3]")).click();
        $(byXpath("html/body/div[1]/div/div/div/div/div/div[3]/div[3]")).click();

        // 2 раза назад
        $(byXpath("html/body/div[1]/div/div/div/div/div/div[3]/div[3]")).click();
        $(byXpath("html/body/div[1]/div/div/div/div/div/div[3]/div[3]")).click();

    }

    @Test
    public void testSix() {

        open("http://infotech.group");
        $(byLinkText("Новости")).click();

        // Технологии
        $(byXpath("html/body/div[1]/div/div/div/ul[1]/li[5]/a")).click();

        // Соглашение о внедрении программных решений в сфере ЖКХ
        $(byXpath("html/body/div[1]/div/div/div/ul[2]/li[4]/a/div[1]/h3")).click();

    }

    @Test
    public void GoogleTestOne(){
        open("http://www.google.com");
       $(byName("q")).setValue("Selenide").pressEnter();

       //$$("#ires").shouldHaveSize(1);

       $("#ires").shouldHave(text("Selenide: лаконичные и стабильные UI тесты на Java"));
        System.out.println("---------------------------------------------------------------------");
        System.out.println($$("#ires").toString());
    }

    @Test
    public void GooglePageObjectTest(){
        GooglePage page = open("http://google.com/ncr", GooglePage.class);
        SearchResultsPage results = page.searchFor("selenide");
        results.getResults().shouldHave(size(10));
        results.getResult(0).shouldHave(text("Selenide: concise UI tests in Java"));
    }

    @Test
    public void testSeven(){
        // Тест поиска
        open("http://www.infotech.group");
        $("#header-prod").click();
        $(".search").click();

        $("#text-to-find").sendKeys("City");
        $("#search-submit-id").click();
        $(".cross-search").click();
    }

    @Test
    public void testGeo4MeOne(){
        open("http://geo4.me");
        $(byXpath("html/body/div[4]/section/div[1]/div/ul/li[2]/a")).click();
        $("#email").sendKeys("89660130695");
        $("#pass").sendKeys("12345");
        $("#loginbutton").click();

   }

    @Test
    public void testGeo4MeTwo(){
        open("http://geo4.me");
        $(byLinkText("EN")).click();
        $(byXpath("html/body/div[4]/section/div[2]/p/a")).click();
        $(".close").click();
        $(byXpath(".//*[@id='msg']/div")).hover();
    }

    @Test
    public void BookingTest(){
        open("http://booking.com");

        // Выбрать даты отдыха 11 октября - 20 октября 2016
        $(By.cssSelector("div.sb-date-field__display")).click();
        $(By.xpath("//form[@id='frm']/div[3]/div/div/div/div[2]/div[2]/div[2]/div[3]/div/div/div/table/tbody/tr[3]/td[2]/span")).click();
        $(By.xpath("//form[@id='frm']/div[3]/div/div/div[2]/div[2]/div/div/div[2]")).click();
        $(By.xpath("//form[@id='frm']/div[3]/div/div/div[2]/div[2]/div[2]/div[2]/div[3]/div/div/div/table/tbody/tr[4]/td[4]/span")).click();

        // Выбрать место отдыха
        $("#ss").sendKeys("Лондон");
        $("#ss").pressTab();

        // Выбрать Отдых
        $(byXpath(".//*[@id='frm']/div[4]/div[1]/div/div/label[2]/input")).click();

        // Выбрать Отели
        $(byXpath(".//*[@id='frm']/div[4]/div[2]/div[2]/label[2]/input")).click();

        // Выбрать 2 комнаты
        $("#no_rooms").selectOption(2);

        // Выбрать 2 взрослых
        $("#group_adults").selectOption(2);

        // Выбрать 1 ребенка
        $("#group_children").selectOption(1);

        // Нажать Submit button
        $(".sb-searchbox__button").click();

    }

    @Test
    public void Geo4MeWebTestLogin(){
        open("http://frontend.infotech.team");
        $("#qa-uname-input").sendKeys("png@infotech.team");
        $("#qa-password-input").sendKeys("admin");
        $("#qa-login-button").click();

    }

    // Page Object OEK Web version tests

    @Test
    public void OEKLoginPageObjectTest() {
        OEKLoginPage page = open("http://frontend.infotech.team", OEKLoginPage.class);
        OEKIssuesPage results = page.SignIn("png@infotech.team", "password");

        results.success();
        // results.getResult(5).shouldHave(text("Южный административный округ, Москва, Донской район"));
        results.getTitle(1).shouldHave(text("Поступила"));
        results.getIssuesList().shouldHaveSize(1); // returns 1 table of contents
    }

    @Test
    public void OEKBrowseIssuesTabsTest(){

        OEKLoginPage page = open("http://frontend.infotech.team", OEKLoginPage.class);
        page.SignIn("png@infotech.team", "password");
        page.BrowseIssuesTabs();

    }

    @Test
    public void OEKBrowseHorizontalTabsTest(){
        OEKLoginPage page = open("http://frontend.infotech.team", OEKLoginPage.class);
        page.SignIn("png@infotech.team", "password");
        page.BrowseHorizontalTabs();
    }

    @Test
    public void OEKBrowsePagesTest(){
        OEKLoginPage page = open("http://frontend.infotech.team", OEKLoginPage.class);
        page.SignIn("png@infotech.team", "password");

        page.BrowsePages();

    }

    @Test
    public void OEKCreateAndCancelIsue(){
        OEKLoginPage page = open("http://frontend.infotech.team", OEKLoginPage.class);
        page.SignIn("png@infotech.team", "password");

        page.CreateAndCancel();
    }

    @Test
    public void OEKCreateIsue(){
        OEKLoginPage page = open("http://frontend.infotech.team", OEKLoginPage.class);
        page.SignIn("png@infotech.team", "password");

        page.CreateIssue();
    }

}
