package tests.lesson_5;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class HoverTests {

    @Test
    void checkText(){
        open("https://github.com/");
        $$(".HeaderMenu-link").findBy(Condition.text("Solutions")).hover();
        $(byText("Enterprise")).click();
        $(".enterprise-hero-background").shouldHave(Condition.text("The AI-powered developer platform."));
    }
}
