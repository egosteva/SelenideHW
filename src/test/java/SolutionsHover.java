import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class SolutionsHover {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        baseUrl = "https://github.com";
    }

    @Test
    void solutionsHover() {
        open(baseUrl);
        $$("button.HeaderMenu-link").findBy(text("Solutions")).hover();
        $(withTagAndText("a", "Enterprise")).click();
        $(byText("Build like the best")).shouldBe(visible);
    }
}
