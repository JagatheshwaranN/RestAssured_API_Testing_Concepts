package authorization.traditional_style;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.commons.codec.binary.Base64;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @restapi
 * @get
 */
public class BasicAuthTestCase {

    @Test(priority = 1)
    public void validateBasicAuth() {

        RestAssured.baseURI = "https://postman-echo.com";
        RestAssured.basePath = "/basic-auth";
        String credentials = "postman:password";
        byte[] basicAuth = Base64.encodeBase64(credentials.getBytes());
        String basicAuthString = new String(basicAuth);
        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.header("Authorization", "Basic "+basicAuthString);
        Response response = requestSpecification.request(Method.GET);
        Boolean status = response.getBody().jsonPath().get("authenticated");
        Assert.assertEquals(status, true);
    }
}
