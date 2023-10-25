package spec;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;


public class RequestAndResponseSpecificationTestCase {

    RequestSpecification requestSpecification, requestSpecUsingRequestSpecBuilder;

    RequestSpecBuilder requestSpecBuilder;

    ResponseSpecification responseSpecification;

    ResponseSpecBuilder responseSpecBuilder;

    @BeforeMethod
    public void setup(){
        requestSpecification = given()
                .baseUri("https://reqres.in/api")
                .basePath("/users/{id}")
                .headers("Accept", "application/json");

        requestSpecBuilder = new RequestSpecBuilder();
        requestSpecUsingRequestSpecBuilder = requestSpecBuilder
                .setBaseUri("https://reqres.in/api")
                .setBasePath("/users/{id}")
                .addHeader("Accept", "application/json")
                .build();

        responseSpecBuilder = new ResponseSpecBuilder();
        responseSpecification = responseSpecBuilder
                .expectStatusCode(200)
                .expectHeader("Content-Type", equalTo("application/json; charset=utf-8"))
                .build();
    }

    @Test(priority = 1)
    public void getMethodUsingRequestAndResponseSpecificationApproach1(){

        given()
                .spec(requestSpecification)
                .pathParam("id", "2")
        .when()
                .get()
        .then()
                .spec(responseSpecification)
                .log()
                .body();
    }

    @Test(priority = 2)
    public void getMethodUsingRequestAndResponseSpecificationApproach2(){

        given()
                .spec(requestSpecUsingRequestSpecBuilder)
                .pathParam("id", "2")
        .when()
                .get()
        .then()
                .spec(responseSpecification)
                .log()
                .body();
    }

}
