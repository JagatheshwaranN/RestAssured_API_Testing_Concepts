package http_methods.traditional_style;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;

/**
 * @restapi
 * @put
 */
public class PutMethodTestCase {

    @Test(priority = 1)
    public void putMethod(){

        HashMap<String, String> updateData = new HashMap<>();
        updateData.put("first_name", "John");
        updateData.put("last_name", "Smith");

        RestAssured.baseURI = "https://reqres.in/api";
        RestAssured.basePath = "/users/2";

        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.contentType(ContentType.JSON);
        Response response = requestSpecification.body(updateData).put();
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200);
        response.prettyPrint();
    }
}
