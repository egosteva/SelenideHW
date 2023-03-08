import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.currentFrameUrl;

public class SoftAssertionsPageCheck {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        baseUrl = "https://github.com";
    }

    @Test
    void SoftAssertionsPageCheck() {
        open("/selenide/selenide");
        $("#wiki-tab").click();
        $("#user-content-welcome-to-the-selenide-wiki").closest("h1").shouldHave(text("Welcome to the selenide wiki!"));

        $(".js-wiki-more-pages-link").click();
        $("#wiki-pages-box").shouldHave(text("SoftAssertions"));

        $(byText("SoftAssertions")).click();
        webdriver().shouldHave(currentFrameUrl(baseUrl + "/selenide/selenide/wiki/SoftAssertions"));
        $("#wiki-body").shouldHave(text("Using JUnit5 extend test class:"));
    }
}
