package ua.net.itlabs;
import org.openqa.selenium.chrome.ChromeDriver;
import com.codeborne.selenide.Configuration;
import org.junit.Test;
import static com.codeborne.selenide.CollectionCondition.*;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

/**
 * Created by User on 04.10.2016.
 */
public class ToDoMVCTest {
    @Test
    public void testCreateCase(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\User\\Documents\\Eclipse Files\\Libraries\\chromedriver.exe");
        Configuration.browser = "chrome";

        open("http://todomvc.com/examples/troopjs_require/");
        $(".new-todo").setValue("task 1").pressEnter();
        $(".new-todo").setValue("task 2").pressEnter();

        $$(".todo-list").shouldHave(exactTexts("task 1", "task 2"));

    }

}
