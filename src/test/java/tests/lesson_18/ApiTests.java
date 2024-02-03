package tests.lesson_18;

import dev.failsafe.internal.util.Assert;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ApiTests {

    @Test
    void checkListUsersSchemeTest(){
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
    void checkPostCreateTest(){
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
    void checkPutCreateTest(){
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
    void checkPatchCreateTest(){
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
    void checkDeleteTest(){
        given()
                .log().all()
                .when()
                .delete("https://reqres.in/api/users/2")
                .then()
                .log().all()
                .statusCode(204);
    }

    @Test
    void checkNegativeTest(){
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
}
