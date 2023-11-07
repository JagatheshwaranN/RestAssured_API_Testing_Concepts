package method_types;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;

public class PostMethodTypesTestCase {

    /*
        1. This is the simplest way to send a POST request using RestAssured. You provide the URL
           directly in the post() method.
        2. Using Fluent API. This approach uses the "Given When Then" style commonly associated
           with RestAssured.
    */
    @Test(priority = 1)
    public void postMethodType1(){

        HashMap<String, String> userData = new HashMap<>();
        userData.put("name", "John");
        userData.put("job", "Tester");

        RestAssured.baseURI = "https://reqres.in";
        RestAssured.basePath = "/api/users";

        Response response = RestAssured.given().contentType(ContentType.JSON).body(userData).post();
        int statusCode = response.getStatusCode();
        System.out.println(statusCode);
        Assert.assertEquals(statusCode, 201);
        response.prettyPrint();
    }

    /*
        1. This is a more flexible approach.The below method makes use of 'RequestSpecification' object
           named 'requestSpecification' using RestAssured. The requestSpecification should have been set
           up with specific details such as the base URI, headers, authentication, etc.
        2. This method uses the 'request()' method of the 'RequestSpecification' object to explicitly
           specify the HTTP method (POST, in this case) and send the request.
        3. This approach is useful when you want to reuse the same 'RequestSpecification' for multiple
           requests and customize headers, parameters, or other request details.
    */
    @Test(priority = 2)
    public void postMethodType2(){

        HashMap<String, String> userData = new HashMap<>();
        userData.put("name", "John");
        userData.put("job", "Tester");

        RestAssured.baseURI = "https://reqres.in";
        RestAssured.basePath = "/api/users";

        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.body(userData);
        Response response = requestSpecification.request(Method.POST);
        int statusCode = response.getStatusCode();
        System.out.println(statusCode);
        Assert.assertEquals(statusCode, 201);
    }

    /*
        1. Similar to the previous method, the below method also makes use of 'RequestSpecification'
           object named 'requestSpecification' using RestAssured.
        2. In this case, the 'post()' method directly being used on the 'RequestSpecification' object
           to send a POST request.
        3. It's a more concise way to send a POST request using the 'RequestSpecification' you have
           already configured.
    */
    @Test(priority = 3)
    public void postMethodType3(){

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
        Assert.assertEquals(statusCode, 201);
    }
}