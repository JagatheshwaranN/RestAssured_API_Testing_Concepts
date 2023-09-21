package http_methods.traditional_style;

import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @restapi
 * @get
 */
public class GetMethodTestCase {

    @Test(priority = 1)
    public void getMethodType1(){

        RestAssured.baseURI = "https://reqres.in";
        RestAssured.basePath = "/api/users/2";
        RequestSpecification requestSpecification = RestAssured.given();
        Response response = requestSpecification.request(Method.GET);
        int statusCode = response.getStatusCode();
        int id = response.getBody().jsonPath().get("data.id");
        Headers headers = response.getHeaders();
        ResponseBody responseBody = response.getBody();
        Assert.assertEquals(statusCode, 200);
        Assert.assertEquals(id, 2);
        System.out.println("Response status code is "+statusCode);
        System.out.println("Response headers are "+headers);
        responseBody.prettyPrint();
    }

    @Test(priority = 2)
    public void getMethodType2(){

        RestAssured.baseURI = "https://reqres.in";
        RequestSpecification requestSpecification = RestAssured.given();
        Response response = requestSpecification.request(Method.GET, "/api/users/2");
        int statusCode = response.getStatusCode();
        int id = response.getBody().jsonPath().get("data.id");
        String responseBody = response.getBody().asString();
        Assert.assertEquals(statusCode, 200);
        Assert.assertEquals(id, 2);
        System.out.println("*********** Response Body as String ***********");
        System.out.println(responseBody);
        Assert.assertTrue(responseBody.contains("2"));
        responseBody = response.getBody().asPrettyString();
        System.out.println("*********** Response Body as Pretty String ***********");
        System.out.println(responseBody);
    }
}
