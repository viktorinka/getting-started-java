package tests.lesson_21.config;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static java.lang.String.format;
import static tests.lesson_21.TestBaseAllure.allureTestOpsSession;
import static tests.lesson_21.TestBaseAllure.projectId;

import org.openqa.selenium.Cookie;

public class ProjectConfig{
    public static void openProjectUrl() {
        open("https://allure.autotests.cloud/favicon.ico");

        Cookie authorizationCookie = new Cookie("ALLURE_TESTOPS_SESSION", allureTestOpsSession);
        getWebDriver().manage().addCookie(authorizationCookie);

        String testCaseUrl = format("https://allure.autotests.cloud/project/%s/test-cases/", projectId);
        open(testCaseUrl);
    }
}
