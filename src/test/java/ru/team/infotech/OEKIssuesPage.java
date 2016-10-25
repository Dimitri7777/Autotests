package ru.team.infotech;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.*;



public class OEKIssuesPage {

    public SelenideElement getTitle(int index) { return $(".cell",index); }

    public SelenideElement getResult(int index) { return $(By.linkText("Адрес"), index); }

    public ElementsCollection getIssuesList() {
        return $$(".mitable");
    }

    public void success(){
        System.out.println("----------------");
        System.out.println("SUCCESS!!!");
    }



}
