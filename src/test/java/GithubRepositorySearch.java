import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;


public class GithubRepositorySearch {
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
//       Configuration.baseUrl = "https://github.com";
    }

    @Test
    void GithubSearch() {
        open("https://github.com");
        $("[placeholder='Search GitHub']").setValue("selenide").pressEnter();
        $$("ul.repo-list li").first().$("a").click();
        //      $("#repository-container-header").shouldHave(text("selenide\n/\nselenide"));
        $("#repository-container-header").shouldHave(text("selenide / selenide"));
        sleep(5000);
    }

    @Test
    void SearchExamples() {
        open("https://github.com");
        // .classname, #id, [], "tag", a[href=abc].red, [attribute="attribute_name"], [attribute='attribute name']
        // найти тег abc - команда ничего не ищет
        $("abc");
        // найти внутри тега abc тег p - команда ничего не ищет
        $("abc").$("p");
        // поиск запускается после команды (экшна) - click, setValue или после проверки - shouldHave
        $("abc").$("p").click();
        $("abc").$("p").shouldHave(visible);
        // после экшна можно продолжать чейнить
        $("abc").$("p").shouldBe(visible).shouldHave(text("abc"));
        $("abc").shouldHave(text("abc")).shouldNotHave(text("def"));
    }
}
