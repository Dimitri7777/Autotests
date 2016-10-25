package ru.team.infotech;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.*;
import org.openqa.selenium.support.FindBy;



public class OEKLoginPage {
    // Элементы логин-формы
    @FindBy(id="qa-uname-input")
    SelenideElement login;

    @FindBy(id="qa-password-input")
    SelenideElement pwd;

    @FindBy(id="qa-login-button")
    SelenideElement submitButton;

    // Вкладки меню "Заявки"
    @FindBy(css=".issues-types>li:nth-child(1)")
    SelenideElement vkladkaBazaDannyh;

    @FindBy(css=".issues-types>li:nth-child(2)")
    SelenideElement vkladkaAvtodor;

    @FindBy(css=".issues-types>li:nth-child(3)")
    SelenideElement vkladkaKontrOrgan;

    @FindBy(css=".issues-types>li:nth-child(4)")
    SelenideElement vkladkaKSED;

    @FindBy(css=".issues-types>li:nth-child(5)")
    SelenideElement vkladkaWebKarta;

    @FindBy(css=".issues-types>li:nth-child(6)")
    SelenideElement vkladkaPortal;

    // Вкладки горизонтального меню
    @FindBy(css="#Shape-Copy-23")
    SelenideElement burgerMenu;

    @FindBy(css=".icon-link.dashboard-link")
    SelenideElement dashBoardTab;

    @FindBy(css=".icon-link.company-link")
    SelenideElement companyTab;

    @FindBy(css=".icon-link.users-link")
    SelenideElement usersTab;

    @FindBy(css=".icon-link.messages-link")
    SelenideElement messagesTab;

    @FindBy(css=".icon-link.docs-link")
    SelenideElement docsTab;

    @FindBy(css=".icon-link.log-link")
    SelenideElement logTab;

    @FindBy(css=".icon-link.reports-link")
    SelenideElement reportsTab;

    @FindBy(css=".bottom-icon-link.export-link")
    SelenideElement exportTab;

    @FindBy(css=".bottom-icon-link.print-link")
    SelenideElement printerTab;

    @FindBy(css=".bottom-icon-link.settings-link")
    SelenideElement settingsTab;

    // Issue pages
    @FindBy(css=".btn.btn-default.to-start")
    SelenideElement startButton;

    @FindBy(css=".btn.btn-default:nth-child(2)")
    SelenideElement firstPage;

    @FindBy(css=".btn.btn-default:nth-child(3)")
    SelenideElement secondPage;

    @FindBy(css=".btn.btn-default:nth-child(8)")
    SelenideElement seventhPage;


    // Create issue elements:

    @FindBy(css=".button.green")
    SelenideElement createButton;

    @FindBy(css=".buttons>a:nth-child(1)")
    SelenideElement cancelButton;


    public OEKIssuesPage SignIn(String username, String password) {
        login.sendKeys(username);
        pwd.sendKeys(password);
        submitButton.click();
        return page(OEKIssuesPage.class);
    }

    public void BrowseIssuesTabs(){
        vkladkaAvtodor.click();
        vkladkaKontrOrgan.click();
        vkladkaKSED.click();
        vkladkaWebKarta.click();
        vkladkaPortal.click();

        vkladkaKSED.click();
        vkladkaAvtodor.click();
    }

    public void BrowseHorizontalTabs(){
        burgerMenu.click();

        dashBoardTab.click();
        companyTab.click();
        usersTab.click();
        messagesTab.click();
        docsTab.click();
        logTab.click();
        reportsTab.click();

        burgerMenu.click();

        exportTab.click();
        printerTab.click();
        settingsTab.click();

    }

    // Browse Issue Pages
    public void BrowsePages(){
        firstPage.click();
        secondPage.click();
        seventhPage.click();
        startButton.click();
    }

    // Create and Cancel Issue
    public void CreateAndCancel(){
        createButton.click();
        cancelButton.click();
    }

    // Create Issue

    public void CreateIssue(){
        createButton.click();


    }

}
