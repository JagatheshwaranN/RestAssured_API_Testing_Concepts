package scenarios;

import io.restassured.config.HeaderConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;
import util.RandomStringGenerator;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class HeadersMergeTestCase {

    @Test(priority = 1)
    public void headersMergeTest() {

        String bearerToken = "1f022d017dc6883f06bad3e8df38886777b077d7130490242af5c92294af4bd9";

        String name = RandomStringGenerator.generateRandomString(10);
        HashMap<String, Object> userData = new HashMap<>();
        userData.put("name", name);
        userData.put("gender", "male");
        userData.put("email", name+"@test.com");
        userData.put("status", "inactive");

        given()
                .headers("Authorization", "Bearer "+bearerToken)
                .header("header1", "value1")
                .header("header1", "value2")
                .contentType(ContentType.JSON)
                .config(RestAssuredConfig.config().
                        headerConfig(HeaderConfig.headerConfig().
                                mergeHeadersWithName("header1")))
                .body(userData)
                .log().headers()
        .when()
                .post("https://gorest.co.in/public/v2/users/")
        .then()
                .statusCode(201)
                .body("name", equalTo(name))
                .log().body();
    }

}
