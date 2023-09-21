package http_methods.traditional_style;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import java.util.HashMap;

/**
 * @restapi
 * @post
 */
public class PostMethodTestCase {

    @Test(priority = 1)
    public void postMethod(){

        HashMap<String, String> userData = new HashMap<>();
        userData.put("name", "John");
        userData.put("job", "Tester");

        RestAssured.baseURI = "https://reqres.in";
        RestAssured.basePath = "/api/users";

        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.contentType(ContentType.JSON);
        Response response = requestSpecification.body(userData).post();
        int statusCode = response.getStatusCode();
        System.out.println(statusCode);
    }
}
