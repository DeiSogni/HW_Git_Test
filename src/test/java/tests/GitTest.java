package tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class GitTest extends TestBase{


    @Test
    void gitSoftAssertiions() {



        open("/selenide/selenide");

        $("#wiki-tab").click();

        $("#wiki-pages-box").$("[type='button']").click();
        $("#wiki-pages-filter").setValue("SoftAssertions");
        $("[data-filterable-for=wiki-pages-filter]").shouldHave(text("SoftAssertions"));
        $("a[href='/selenide/selenide/wiki/SoftAssertions']").click();
        $("#wiki-body").shouldHave(text("""
                @ExtendWith({SoftAssertsExtension.class})
                class Tests {
                  @Test
                  void test() {
                    Configuration.assertionMode = SOFT;
                    open("page.html");
                                
                    $("#first").should(visible).click();
                    $("#second").should(visible).click();
                  }
                }
                """));


    }
}