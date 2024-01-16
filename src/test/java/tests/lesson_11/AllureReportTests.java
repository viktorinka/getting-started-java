package tests.lesson_11;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.logevents.SelenideLogger.step;
import static org.openqa.selenium.By.linkText;

public class AllureReportTests {
    @Test
    void selenideTest(){
        SelenideLogger.addListener("allure", new AllureSelenide());
        open("https://github.com");
        $(".header-search-button").click();
        $("#query-builder-test").sendKeys("eroshenkoam/allure-example");
        $("#query-builder-test").submit();

        $(linkText("eroshenkoam/allure-example")).click();
        $(("#issues-tab")).click();
        $(withText("#80")).should(Condition.exist);
    }

        @Test
        @Feature("Issue в репозитории")
        @Story("Создание Issue")
        @Owner("eroshenkoam")
        @Severity(SeverityLevel.BLOCKER)
        @Link(value = "Testing", url = "https://testing.github.com")
        @DisplayName("Создание Issue для авторизованного пользователя")
        public void staticLabelsTest() {
        }

        @Test
        public void DynamicLabelsTest() {
            Allure.getLifecycle().updateTestCase(
                    t -> t.setName("Создание Issue для авторизованного пользователя")
            );
            Allure.feature("Issue в репозитории");
            Allure.story("Создание Issue");
            Allure.label("owner", "eroshenkoam");
            Allure.label("severity", SeverityLevel.CRITICAL.value());
            Allure.link("Testing", "https://testing.github.com");
        }

    private static final String REPOSITORY = "eroshenkoam/allure-example";
    private static final int ISSUE = 80;

    @Test
    public void LambdaStepTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Открываем главную страницу", () -> {
            open("https://github.com");
        });
        step("Ищем репозиторий " + REPOSITORY, () -> {
            $(".header-search-button").click();
            $("#query-builder-test").sendKeys(REPOSITORY);
            $("#query-builder-test").submit();
        });
        step("Кликаем по ссылке репозитория " + REPOSITORY, () -> {
            $(linkText(REPOSITORY)).click();
        });
        step("Открываем таб Issues", () -> {
            $("#issues-tab").click();
        });
        step("Проверяем наличие Issue с номером " + ISSUE, () -> {
            $(withText("#" + ISSUE)).should(Condition.exist);
        });
    }

    @Test
    public void AnnotatedStepTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        WebSteps steps = new WebSteps();

        steps.openMainPage();
        steps.searchForRepository(REPOSITORY);
        steps.clickOnRepositoryLink(REPOSITORY);
        steps.openIssuesTab();
        steps.shouldSeeIssueWithNumber(ISSUE);

    }
}
