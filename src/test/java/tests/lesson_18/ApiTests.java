package tests.lesson_18;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;
import tests.lesson_18.models.lombok.UserDataLombok;
import tests.lesson_18.models.pojo.UserData;
import tests.lesson_18.models.pojo.UserPojo;
import tests.lesson_18.spec.Spec;

import static helpers.CustomAllureListener.withCustomTemplates;
import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ApiTests {

    @Test
    void checkListUsersSchemeTest() {
        given()
                .log().uri()
                .when()
                .get("https://reqres.in/api/users?page=2")
                .then()
                .log().status()
                .log().body()
                .statusCode(200)
                .body(matchesJsonSchemaInClasspath("listUsersResponseScheme.json"));
    }

    @Test
    void checkPostCreateTest() {
        String body = "{ \"name\": \"morpheus\", \"job\": \"leader\" }";
        given()
                .log().body()
                .body(body)
                .contentType(ContentType.JSON)
                .when()
                .post("https://reqres.in/api/users")
                .then()
                .log().status()
                .log().body()
                .statusCode(201)
                .body("name", is("morpheus")).body("job", is("leader"));
    }

    @Test
    void checkPutCreateTest() {
        String body = "{ \"name\": \"morpheus\", \"job\": \"zion resident\" }";
        given()
                .log().body()
                .body(body)
                .contentType(ContentType.JSON)
                .when()
                .put("https://reqres.in/api/users/2")
                .then()
                .log().status()
                .log().body()
                .statusCode(200)
                .body("name", is("morpheus")).body("job", is("zion resident"));
    }

    @Test
    void checkPatchCreateTest() {
        String body = "{ \"name\": \"morpheus\", \"job\": \"zion resident\" }";
        String expectResponse = "zion resident";
        String actualResponse = given()
                .log().body()
                .body(body)
                .contentType(ContentType.JSON)
                .when()
                .patch("https://reqres.in/api/users/2")
                .then()
                .log().status()
                .log().body()
                .statusCode(200)
                .extract().path("job");
        assertEquals(actualResponse, expectResponse);
    }

    @Test
    void checkDeleteTest() {
        given()
                .log().all()
                .when()
                .delete("https://reqres.in/api/users/2")
                .then()
                .log().all()
                .statusCode(204);
    }

    @Test
    void checkNegativeTest() {
        String body = "{ \"name\": \"morpheus\", \"job\": \"test }";
        given()
                .log().body()
                .body(body)
                .contentType(ContentType.JSON)
                .when()
                .patch("https://reqres.in/api/users/2")
                .then()
                .log().status()
                .log().body()
                .statusCode(400);
    }

    @Test
    void checkPostCreateModelTest() {
        String body = "{ \"name\": \"morpheus\", \"job\": \"leader\" }";
        UserPojo pojo = Spec.request
                .body(body)
                .when()
                .post("/users")
                .then()
                .spec(Spec.responseSpec)
                .extract().as(UserPojo.class);
        assertEquals("leader", pojo.getJob());
    }

    @Test
    void checkGetSingleUserModelTest() {
        UserData dataPojo = given()
                .spec(Spec.request)
                .when()
                .get("/users/2")
                .then()
                .log().body()
                .statusCode(200)
                .extract().as(UserData.class);
        assertEquals(2, dataPojo.getData().getId());
    }

    @Test
    void checkGetSingleUserModelTest2() {
        UserPojo pojo = given()
                .spec(Spec.request)
                .when()
                .get("/users/2")
                .then()
                .log().body()
                .statusCode(200)
                .extract().as(UserPojo.class);
        assertEquals(2, pojo.getId());
    }

    @Test
    void checkGetSingleUserLombokTest() {
        UserDataLombok dataLombok = given()
                .spec(Spec.request)
                .when()
                .get("/users/2")
                .then()
                .log().body()
                .statusCode(200)
                .extract().as(UserDataLombok.class);
        assertEquals(2, dataLombok.getUserLombok().getId());
    }

    @Test
    void checkGetSingleUserGroovyTest() {
        given()
                .spec(Spec.request)
                .when()
                .get("/users")
                .then()
                .log().body()
                .statusCode(200)
                .body("data.findAll{it.first_name =~/[a-zA-Z]+/}.first_name.flatten()",
                        hasItem("Janet"))
                .body("data.last_name[0]", equalTo("Bluth"));
    }

    @Test
    void checkGetSingleUserWithAllureTest() {
        UserDataLombok dataLombok = given()
                .filter(new AllureRestAssured())
                .spec(Spec.request)
                .when()
                .get("/users/2")
                .then()
                .log().body()
                .statusCode(200)
                .extract().as(UserDataLombok.class);
        assertEquals(2, dataLombok.getUserLombok().getId());
    }

    @Test
    void checkGetSingleUserWithCustomAllureTest() {
        UserDataLombok dataLombok = given()
                .filter(withCustomTemplates())
                .spec(Spec.request)
                .when()
                .get("/users/2")
                .then()
                .log().body()
                .statusCode(200)
                .extract().as(UserDataLombok.class);
        assertEquals(2, dataLombok.getUserLombok().getId());
    }

    @Test
    void checkGetSingleUserWithStepAllureTest() {
        UserDataLombok dataLombok = step("Make request", () ->
                given()
                .spec(Spec.request)
                .when()
                .get("/users/2")
                .then()
                .log().body()
                .statusCode(200)
                .extract().as(UserDataLombok.class));
        step("Verify response", () ->
        assertEquals(2, dataLombok.getUserLombok().getId()));
    }
}
