package tests.lesson_21;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static helpers.CustomAllureListener.withCustomTemplates;
import static io.restassured.RestAssured.with;
import static tests.lesson_21.TestBaseAllure.allureTestOpsSession;
import static tests.lesson_21.TestBaseAllure.xsrfToken;

public class SpecAllure {
    public static RequestSpecification request = with()
            .baseUri("https://allure.autotests.cloud")
            .header("X-XSRF-TOKEN", xsrfToken)
            .cookies("XSRF-TOKEN", xsrfToken,
                    "ALLURE_TESTOPS_SESSION", allureTestOpsSession)
            .basePath("/api")
            .log().all()
            .contentType("application/json;charset=UTF-8")
            .filter(withCustomTemplates());

    public static ResponseSpecification responseSpec = new ResponseSpecBuilder()
            .log(LogDetail.STATUS)
            .log(LogDetail.BODY)
            .expectStatusCode(200)
            .build();

}
