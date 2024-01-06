package log;

import io.restassured.config.LogConfig;
import io.restassured.config.RestAssuredConfig;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

/**
 * @restapi
 * @get
 */
public class LogBasedOnConditionTestCase {

    @Test(priority = 1)
    public void generateLogWhenValidationFail(){

        given()
        .when()
                .log()
                .ifValidationFails()
                .get("https://reqres.in/api/users//2")
        .then()
                .statusCode(200)
                .body("data.id", equalTo(2));
    }

    @Test(priority = 2)
    public void generateLogWhenError(){

    given()
        .when()
                .post("https://reqres.in/api/register")
        .then()
                .log().ifError();

    }

    @Test(priority = 3)
    public void generateLogBasedOnConditionApproach1(){

        given()
        .when()
                .get("https://reqres.in/api/users/2")
        .then()
                .log().ifStatusCodeIsEqualTo(200);
    }

    @Test(priority = 4)
    public void generateLogBasedOnConditionApproach2(){

        given()
        .when()
                .get("https://reqres.in/api/users/2")
        .then()
                .log().ifStatusCodeMatches(Matchers.equalTo(200));
    }

    @Test(priority = 5)
    public void generateLogWhenValidationFailUsingConfig(){

        given()
                .config(RestAssuredConfig.config().logConfig(LogConfig.logConfig().enableLoggingOfRequestAndResponseIfValidationFails()))
        .when()
                .get("https://reqres.in/api/users/2")
        .then()
                .statusCode(200)
                .body("data.id", equalTo(1));
    }

}
