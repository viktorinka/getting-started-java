package pages;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class AllurePage {

    @Step("Authorization user")
    public AllurePage auth(String userName, String password) {
        open("https://allure.autotests.cloud/login");
        $("[name=username]").setValue(userName);
        $("[name=password]").setValue(password);
        $("button[type=submit]").click();
        return this;
    }

    @Step("Delete case")
    public AllurePage deleteCase() {
        $(".Checkbox.LoadableTreeNodeCheckbox__box").click();
        $(".LoadableTreeControlPanel .Button").click();
        $(".Menu__item_danger").click();
        return this;
    }

    @Step("Open project")
    public AllurePage openProject() {
        open("https://allure.autotests.cloud/project/4033/test-cases/");
        return this;
    }
}
