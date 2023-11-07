package method_types;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DeleteMethodTypesTestCase {

    /*
       1. The below method directly sends a DELETE request to the specified URL without the need
          for creating a separate 'RequestSpecification' object.
       2. It's a simple way to send a DELETE request if you don't need to set custom headers or
          parameters for that specific request.
    */
    @Test(priority = 1)
    public void deleteMethodType1(){

        RestAssured.baseURI = "https://reqres.in";
        RestAssured.basePath = "/api/users/2";

        Response response = RestAssured.delete();
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 204);
    }

    /*
        1. The below method makes use of 'RequestSpecification' object named 'requestSpecification'
           using RestAssured.
        2. This method uses the 'request()' method of the 'RequestSpecification' object to explicitly
           specify the HTTP method (DELETE, in this case) and send the request.
        3. This approach is useful when you want to reuse the same 'RequestSpecification' for multiple
           requests and customize headers, parameters, or other request details.
    */
    @Test(priority = 2)
    public void deleteMethodType2(){

        RestAssured.baseURI = "https://reqres.in";
        RestAssured.basePath = "/api/users/2";

        RequestSpecification requestSpecification = RestAssured.given();
        Response response = requestSpecification.request(Method.DELETE);
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 204);
    }

    /*
        1. Similar to the previous method, the below method also makes use of 'RequestSpecification'
           object named 'requestSpecification' using RestAssured.
        2. In this case, the 'delete()' method directly being used on the 'RequestSpecification'
           object to send a DELETE request.
        3. It's a more concise way to send a DELETE request using the 'RequestSpecification' you have
           already configured.
    */
    @Test(priority = 3)
    public void deleteMethodType3(){

        RestAssured.baseURI = "https://reqres.in";
        RestAssured.basePath = "/api/users/2";

        RequestSpecification requestSpecification = RestAssured.given();
        Response response = requestSpecification.delete();
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 204);
    }
}
