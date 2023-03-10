import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.*;

public class DragAndDrop {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        baseUrl = "https://the-internet.herokuapp.com";
    }

    @Test
    void dragAndDropAction() {
        open("/drag_and_drop");
        actions().dragAndDrop($("#column-a"), $("#column-b"));
        $("#column-b").shouldHave(text("A"));
    }

    @Test
    void dragAndDropElementToElement() {
        open("/drag_and_drop");
        $("#column-a").dragAndDropTo("#column-b");
        $("#column-b").shouldHave(text("A"));
    }
}
