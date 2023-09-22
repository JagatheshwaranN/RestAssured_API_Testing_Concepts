package http_methods.traditional_style;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GetMethodTypesTestCase {

    @Test(priority = 1)
    public void getMethodType1(){

        RestAssured.baseURI = "https://reqres.in";
        RestAssured.basePath = "/api/users/2";
        Response response = RestAssured.get();
        int statusCode = response.getStatusCode();
        int id = response.getBody().jsonPath().get("data.id");
        Assert.assertEquals(statusCode, 200);
        Assert.assertEquals(id, 2);
        System.out.println("Response status code is "+statusCode);
    }

    @Test(priority = 2)
    public void getMethodType2(){

        RestAssured.baseURI = "https://reqres.in";
        RestAssured.basePath = "/api/users/2";
        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.header("Content-Type", "application/json");
        Response response = requestSpecification.request(Method.GET);
        int statusCode = response.getStatusCode();
        int id = response.getBody().jsonPath().get("data.id");
        Assert.assertEquals(statusCode, 200);
        Assert.assertEquals(id, 2);
        System.out.println("Response status code is "+statusCode);
    }

    @Test(priority = 3)
    public void getMethodType3(){

        RestAssured.baseURI = "https://reqres.in";
        RestAssured.basePath = "/api/users/2";
        RequestSpecification requestSpecification = RestAssured.given();
        Response response = requestSpecification.get();
        int statusCode = response.getStatusCode();
        int id = response.getBody().jsonPath().get("data.id");
        Assert.assertEquals(statusCode, 200);
        Assert.assertEquals(id, 2);
        System.out.println("Response status code is "+statusCode);
    }
}
