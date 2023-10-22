package log;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

/**
 * @restapi
 * @get
 */
public class LoggingTestCase {

    @Test(priority = 1)
    public void logHeaders(){
        given()
        .when()
                .get("https://reqres.in/api/users/2")
        .then()
                .statusCode(200)
                .body("data.id", equalTo(2))
                .log().headers();
    }

    @Test(priority = 2)
    public void logCookies(){
        given()
        .when()
                .get("https://reqres.in/api/users/2")
        .then()
                .statusCode(200)
                .body("data.id", equalTo(2))
                .log().cookies();
    }

    @Test(priority = 3)
    public void logStatus(){
        given()
        .when()
                .get("https://reqres.in/api/users/2")
        .then()
                .statusCode(200)
                .body("data.id", equalTo(2))
                .log().status();
    }

    @Test(priority = 4)
    public void logBody(){
        given()
        .when()
                .get("https://reqres.in/api/users/2")
        .then()
                .statusCode(200)
                .body("data.id", equalTo(2))
                .log().body();
    }

    @Test(priority = 5)
    public void logAll(){
        given()
        .when()
                .get("https://reqres.in/api/users/2")
        .then()
                .statusCode(200)
                .body("data.id", equalTo(2))
                .log().all();
    }

    @Test(priority = 6)
    public void logEverything(){
        given()
        .when()
                .get("https://reqres.in/api/users/2")
        .then()
                .statusCode(200)
                .body("data.id", equalTo(2))
                .log().everything(true);
    }

}
