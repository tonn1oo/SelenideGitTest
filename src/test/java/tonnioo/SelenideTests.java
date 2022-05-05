package tonnioo;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class SelenideTests {

    @BeforeAll
    static void config() {
        Configuration.baseUrl = "https://github.com";
    }

    @Test
    void SelenideTest() {
        ///  Открыть страницу Selenide в Github
        open("/selenide/selenide");

        /// Перейдити в раздел Wiki проекта
        $("#wiki-tab").click();

        //Убедится, что в списке страниц (Pages) есть страница SoftAssertions
        $(".markdown-body").shouldHave(text("Soft assertions"));

        /// Откройть страницу SoftAssertions, проверить что внутри есть пример кода для JUnit5
        $(".markdown-body").$(byText("Soft assertions")).click();
        $$(".markdown-body").find(text("Using JUnit5 extend test class")).shouldBe(visible);

    }
}
