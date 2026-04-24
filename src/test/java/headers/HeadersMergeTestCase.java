package headers;

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
                .log().all()
        .when()
                .post("https://gorest.co.in/public/v2/users/")
        .then()
                .statusCode(201)
                .body("name", equalTo(name))
                .log().body();
    }

    /*
      Yep — what you’re seeing is actually expected behavior, but it trips a lot of people up because
      logging ≠ actual request structure.

      Your log shows:

      Headers:
      Authorization=Bearer xxx
      header1=value1
      header1=value2
      Content-Type=application/json
      Content-Type=application/json
      Content-Type=application/json

      At first glance, it looks like:

      headers are duplicated
      merge is not working ❌

      But that’s not the full story.

      Key Insight

      👉 .log().headers() prints headers as they were added internally,
      NOT how they are finally serialized into the HTTP request.

      What mergeHeadersWithName("header1") actually does

      It affects the final HTTP request sent over the wire, not the log output.

      But during request execution → it becomes:
      header1: value1, value2

      ✔ Merge happens late (during request building)
      ❌ Log does not reflect the merged result
     */
}
