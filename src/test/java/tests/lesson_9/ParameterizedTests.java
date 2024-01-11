package tests.lesson_9;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.stream.Stream;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class ParameterizedTests {
    @BeforeEach
    void openSite() {
        open("https://github.com/");
    }

    @DisplayName("Поиск названий секций на странице {0} - с помощью ValueSource")
    @ParameterizedTest
    @ValueSource(strings = {"Product",
            "Solutions"})
    void searchSectionValue(String value) {
        $(".header-menu-wrapper").shouldHave(Condition.text(value));
    }

    @DisplayName("Поиск названий секций на странице {0} - с помощью EnumSource")
    @ParameterizedTest
    @EnumSource(SectionNames.class)
    void searchSectionEnum(SectionNames value) {
        $(".header-menu-wrapper").shouldHave(Condition.text(String.valueOf(value)));
    }

    @DisplayName("Поиск названий секций на странице {0} - с помощью MethodSource")
    @ParameterizedTest
    @MethodSource
    void searchSectionMethod(String value, String text) {
        $(".header-menu-wrapper").shouldHave(Condition.text(value));
        $(".header-menu-wrapper").shouldHave(Condition.text(text)); // второй аргумент дурацкий потому что ничего не придумала и хотела сделать 2 параметра
    }

    static Stream<Arguments> searchSectionMethod() {
        return Stream.of(
                Arguments.of("Product", "Product"),
                Arguments.of("Solutions", "Solutions")
        );
    }

    @DisplayName("Поиск названий секций на странице {0} - с помощью MethodSource")
    @ParameterizedTest
    @CsvSource(value = {"Product, Product",
                        "Solutions, Solutions"})
    void searchSectionCsv(String value, String text) {
        $(".header-menu-wrapper").shouldHave(Condition.text(value));
        $(".header-menu-wrapper").shouldHave(Condition.text(text)); // второй аргумент дурацкий потому что ничего не придумала и хотела сделать 2 параметра
    }
}


