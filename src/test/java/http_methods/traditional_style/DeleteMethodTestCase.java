package http_methods.traditional_style;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @restapi
 * @delete
 */
public class DeleteMethodTestCase {

    @Test(priority = 1)
    public void delete(){

        RestAssured.baseURI = "https://reqres.in";
        RestAssured.basePath = "/api/users/2";

        RequestSpecification requestSpecification = RestAssured.given();
        Response response = requestSpecification.delete();
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 204);
    }
}
