package tests.lesson_8;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import pages.RegistrationFormPage;
import tests.TestBase;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;

public class RegistrationTestWithFakerTests extends TestBase {

    RegistrationFormPage registrationFormPage = new RegistrationFormPage();
    Faker faker = new Faker();
    String firstName = faker.address().firstName();
    String lastName = faker.address().lastName();
    String email = faker.internet().emailAddress();
    String number = String.valueOf(faker.number().randomNumber(10, true));
    String address = faker.address().streetAddress();
    String subject = faker.options().option("Accounting", "Maths", "Arts", "English", "Physics", "Chemistry",
        "Computer Science", "Economics", "Social Studies", "History", "Civics", "Commerce", "Hindi", "Biology");
    String hobbies = faker.options().option("Reading", "Sports", "Music");
    String gender = faker.demographic().sex();
    static Map<String, String[]> mapStateWithCity = Map.of(
        "NCR", new String[]{"Delhi", "Gurgaon", "Noida"},
        "Uttar Pradesh", new String[]{"Agra", "Lucknow", "Merrut"},
        "Haryana", new String[]{"Karnal", "Panipat"},
        "Rajasthan", new String[]{"Jaipur", "Jaiselmer"});
    String state = faker.options().option(mapStateWithCity.keySet().toArray()).toString();
    String city = faker.options().option(mapStateWithCity.get(state));
    Date fakerDateOfBirthday = faker.date().birthday();
    String dayOfBirth = (new SimpleDateFormat("dd", Locale.ENGLISH)).format(fakerDateOfBirthday);
    String monthOfBirth = (new SimpleDateFormat("MMMM", Locale.ENGLISH)).format(fakerDateOfBirthday);
    String yearOfBirth = (new SimpleDateFormat("y", Locale.ENGLISH)).format(fakerDateOfBirthday);
    String pictureName = "/Users/viktoriya/IdeaProjects/getting-started-java/src/test/resources/file.jpeg";


    @Test
    void Test() {
        registrationFormPage.openPage()
//            .setFirstName(firstName)
//            .setLastName(lastName)
//            .setEmail(email)
//            .setGender(gender)
//            .setNumber(number)
//            .setDateOfBirth(dayOfBirth, monthOfBirth, yearOfBirth)
//            .setSubject(subject)
//            .setHobies(hobbies)
            .setPicture(pictureName)
            .setCurrentAddress(address)
            .setState(state)
            .setCity(city)
            .pressSubmit()
            .checkResult()
            .checkResult()
            .verifyResultsModalData("Student Name", firstName + " " + lastName)
            .verifyResultsModalData("Student Email", email)
            .verifyResultsModalData("Gender", gender)
            .verifyResultsModalData("Mobile", number)
            .verifyResultsModalData("Date of Birth", dayOfBirth + " " + monthOfBirth + "," + yearOfBirth)
            .verifyResultsModalData("Subjects", subject)
            .verifyResultsModalData("Hobbies", hobbies)
            .verifyResultsModalData("Picture", pictureName)
            .verifyResultsModalData("Address", address)
            .verifyResultsModalData("State and City", state + " " + city);
    }
}
