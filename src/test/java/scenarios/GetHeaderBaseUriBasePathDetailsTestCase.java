package scenarios;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.QueryableRequestSpecification;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.SpecificationQuerier;
import org.testng.annotations.Test;

import java.util.HashMap;

public class GetHeaderBaseUriBasePathDetailsTestCase {

    @Test(priority = 1)
    public void getHeaderBaseUriBasePathDetails(){

        HashMap<String, String> userData = new HashMap<>();
        userData.put("name", "John");
        userData.put("job", "Tester");

        RequestSpecification requestSpecification =
                RestAssured.given()
                        .baseUri("https://reqres.in/api")
                        .basePath("/users")
                        .contentType("application/json")
                        .body(userData);
        Response response = requestSpecification.request(Method.POST);
        response.prettyPrint();

        QueryableRequestSpecification queryableRequestSpecification =
                SpecificationQuerier.query(requestSpecification);

        System.out.println(queryableRequestSpecification.getHeaders());
        System.out.println(queryableRequestSpecification.getBaseUri());
        System.out.println(queryableRequestSpecification.getBasePath());
        System.out.println(queryableRequestSpecification.getContentType());
        System.out.println(queryableRequestSpecification.getMethod());
        System.out.println(queryableRequestSpecification.getHttpClient().getClass().getName());
    }

}
