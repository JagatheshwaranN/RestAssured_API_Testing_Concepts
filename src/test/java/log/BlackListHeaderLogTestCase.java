package log;

import io.restassured.config.LogConfig;
import io.restassured.config.RestAssuredConfig;
import org.testng.annotations.Test;
import util.RandomStringGenerator;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

/**
 * @restapi
 * @post
 */
public class BlackListHeaderLogTestCase {

    @Test(priority = 1)
    public void validateBlackListHeaderLog(){

        String bearerToken = "1f022d017dc6883f06bad3e8df38886777b077d7130490242af5c92294af4bd9";

        String name = RandomStringGenerator.generateRandomString(10);
        HashMap<String, Object> userData = new HashMap<>();
        userData.put("name", name);
        userData.put("gender", "male");
        userData.put("email", name+"@test.com");
        userData.put("status", "inactive");

        given()
                .headers("Authorization", "Bearer "+bearerToken)
                .contentType("application/json")
                .body(userData)
                .config(RestAssuredConfig.config().logConfig(LogConfig.logConfig().blacklistHeader("Authorization")))
                .log()
                .all()
        .when()
                .post("https://gorest.co.in/public/v2/users/")
        .then()
                .statusCode(201)
                .body("name", equalTo(name))
                .log().body();
    }

    @Test(priority = 1)
    public void validateBlackListHeadersLog(){

        String bearerToken = "1f022d017dc6883f06bad3e8df38886777b077d7130490242af5c92294af4bd9";

        String name = RandomStringGenerator.generateRandomString(10);
        HashMap<String, Object> userData = new HashMap<>();
        userData.put("name", name);
        userData.put("gender", "male");
        userData.put("email", name+"@test.com");
        userData.put("status", "inactive");

        Set<String> headers = new HashSet<>();
        headers.add("Authorization");
        headers.add("Content-Type");

        given()
                .headers("Authorization", "Bearer "+bearerToken)
                .contentType("application/json")
                .body(userData)
                .config(RestAssuredConfig.config().logConfig(LogConfig.logConfig().blacklistHeaders(headers)))
                .log()
                .all()
        .when()
                .post("https://gorest.co.in/public/v2/users/")
        .then()
                .statusCode(201)
                .body("name", equalTo(name))
                .log().body();
    }

}
