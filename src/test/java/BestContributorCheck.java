import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class BestContributorCheck {

    @Test
    void AndreiSolntsevShouldBeTheFirst() {
        open("https://github.com/selenide/selenide");
        $("div.Layout-sidebar").$(byText("Contributors"))
        // .closest(".BorderGrid-cell").$$("ul li").first().hover();
           .closest("h2").sibling(0).$$("li").first().hover();
        //  $$(".Popover-message").findBy(visible).shouldHave(text("Andrei Solntsev"));
        $(".Popover-message").shouldHave(text("Andrei Solntsev"));
    }
}
