package spec;

import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class MultipleSpecificationWithGivenTestCase {

    RequestSpecification requestSpec;

    @BeforeClass
    public void setRequestSpecification(){

        requestSpec = given()
                .baseUri("https://reqres.in/api")
                .basePath("/users");
    }

    @Test(priority = 1)
    public void getSingleUser(){

        given(requestSpec)
        .when()
                .get("/2")
        .then()
                .statusCode(200)
                .log()
                .body();
    }

    @Test(priority = 2)
    public void getAllUsers(){

        given(requestSpec)
        .when()
                .get()
        .then()
                .statusCode(200)
                .log()
                .body();
    }

}
