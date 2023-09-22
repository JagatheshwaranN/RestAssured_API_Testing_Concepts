package method_types;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GetMethodTypesTestCase {

    /*
       1. The below method directly sends a GET request to the specified URL without the need for
          creating a separate 'RequestSpecification' object.
       2. It's a simple way to send a GET request if you don't need to set custom headers or
          parameters for that specific request.
    */
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

    /*
        1. The below method make use of 'RequestSpecification' object named 'requestSpecification'
           using RestAssured.
        2. This method uses the 'request()' method of the 'RequestSpecification' object to explicitly
           specify the HTTP method (GET, in this case) and send the request.
        3. This approach is useful when you want to reuse the same 'RequestSpecification' for multiple
           requests and customize headers, parameters, or other request details.
    */
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

    /*
        1. Similar to the previous method, the below method also make use of 'RequestSpecification'
           object named 'requestSpecification' using RestAssured.
        2. In this case, the 'get()' method directly being used on the 'RequestSpecification' object
           to send a GET request.
        3. It's a more concise way to send a GET request using the 'RequestSpecification' you have
           already configured.
    */
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
