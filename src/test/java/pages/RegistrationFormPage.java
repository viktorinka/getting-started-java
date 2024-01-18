package pages;

import com.github.javafaker.Faker;
import components.Calendar;
import components.CheckResult;
import io.qameta.allure.Step;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationFormPage {

    Calendar calendar = new Calendar();
    CheckResult checkResult = new CheckResult();

    public RegistrationFormPage openPage() {
        open("/automation-practice-form");
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");
        return this;
    }

    public RegistrationFormPage setFirstName(String value) {
        $("#firstName").setValue(value);
        return this;
    }

    public RegistrationFormPage setLastName(String value) {
        $("#lastName").setValue(value);

        return this;
    }

    public RegistrationFormPage setEmail(String value) {
        $("#userEmail").setValue(value);

        return this;
    }

    public RegistrationFormPage setGender(String value) {
        $(byText(value)).click();

        return this;
    }

    public RegistrationFormPage setNumber(String value) {
        $("#userNumber").setValue(value);

        return this;
    }

    public RegistrationFormPage setDateOfBirth(String day, String month, String year) {
        $("#dateOfBirthInput").click();

        calendar.setDate(day, month, year);

        return this;
    }

    public RegistrationFormPage setSubject(String value) {
        $("#subjectsInput").setValue(value).pressEnter();

        return this;
    }

    public RegistrationFormPage setHobies(String value) {
        $("#hobbiesWrapper").$(byText(value)).click();

        return this;
    }

    public RegistrationFormPage setPicture(String value) {
        $("#uploadPicture").uploadFile(new File("src/test/resources/file.jpeg"));

        return this;
    }

    public RegistrationFormPage setCurrentAddress(String value) {
        $("#currentAddress").setValue(value);

        return this;
    }

    public RegistrationFormPage setState(String value) {
        $("#state").click();
        $(byText(value)).click();

        return this;
    }

    public RegistrationFormPage setCity(String value) {
        $("#city").click();
        $(byText(value)).click();

        return this;
    }

    public RegistrationFormPage pressSubmit() {
        $("#submit").click();

        return this;
    }
    public RegistrationFormPage checkResult() {
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        return this;
    }

    public RegistrationFormPage verifyResultsModalData(String labelText, String valuesText) {
        $(".table-responsive").$(byText(labelText)).parent().shouldHave((text(valuesText)));
        return this;
    }

}
