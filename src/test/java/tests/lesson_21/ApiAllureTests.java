package tests.lesson_21;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.AllurePage;
import tests.lesson_21.model.CreateTestCaseBody;
import tests.lesson_21.model.CreateTestCaseResponse;

import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;
import static tests.lesson_21.config.ProjectConfig.openProjectUrl;
@Tag("api")
public class ApiAllureTests extends TestBaseAllure {
    AllurePage allurePage = new AllurePage();
    Faker faker = new Faker();
    String testCaseName = faker.funnyName().name();

    @Test
    @DisplayName("Create test case")
    void createTest() {

        CreateTestCaseBody testCaseBody = new CreateTestCaseBody();
        testCaseBody.setName(testCaseName);

        //openProjectUrl();
        CreateTestCaseResponse createTestCaseResponse = step("Make request", () ->
                given(SpecAllure.request)
                        .body(testCaseBody)
                        .queryParam("projectId", projectId)
                        .when()
                        .post("/rs/testcasetree/leaf")
                        .then()
                        .spec(SpecAllure.responseSpec)
                        .extract().as(CreateTestCaseResponse.class));
        step("Verify testcase name", () -> {
            assertThat(createTestCaseResponse.getName()).isEqualTo(testCaseName);
        });
    }

    @Test
    @DisplayName("Delete test case")
    void deleteTest() {
        allurePage.auth("allure8", "allure8");
        allurePage.deleteCase();
    }
}
