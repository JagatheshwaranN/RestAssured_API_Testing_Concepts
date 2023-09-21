package authorization.traditional_style;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;
import util.RandomStringGenerator;

import java.util.HashMap;

/**
 * @restapi
 * @post
 */
public class BearerTokenTestCase {

    @Test(priority = 1)
    public void validateBearerToken(){

        String bearerToken = "1f022d017dc6883f06bad3e8df38886777b077d7130490242af5c92294af4bd9";

        String name = RandomStringGenerator.generateRandomString(10);
        HashMap<String, Object> userData = new HashMap<>();
        userData.put("name", name);
        userData.put("gender", "male");
        userData.put("email", name+"@test.com");
        userData.put("status", "inactive");

        RestAssured.baseURI = "https://gorest.co.in/public/v2";
        RestAssured.basePath = "/users";

        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.header("Authorization", "Bearer "+bearerToken);
        requestSpecification.contentType(ContentType.JSON);
        Response response = requestSpecification.body(userData).post();
        int statusCode = response.getStatusCode();
        System.out.println(statusCode);
        Assert.assertEquals(statusCode, 201);
    }
}
