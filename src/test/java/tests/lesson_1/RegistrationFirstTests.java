package tests.lesson_1;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.RegistrationFormPage;

public class RegistrationFirstTests {
    @BeforeAll
    static void setUp() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    RegistrationFormPage registrationFormPages = new RegistrationFormPage();

    @Test
    void Test() {

        String firstName = "TestName";
        String lastName = "TestLastName";

        registrationFormPages.openPage();
        registrationFormPages.setFirstName(firstName);
        registrationFormPages.setLastName(lastName);
        registrationFormPages.setEmail("test@mail.ru");
        registrationFormPages.setGender("Other");
        registrationFormPages.setNumber("1234567890");
        registrationFormPages.setDateOfBirth("30", "July", "2008");
        registrationFormPages.setSubject("Math");
        registrationFormPages.setHobies("sport");
        // registrationFormPages.setPicture();
        registrationFormPages.setCurrentAddress("test");
        // registrationFormPages.setState();
        registrationFormPages.pressSubmit();
        registrationFormPages.checkResult();
    }
}
