package spec;

import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.with;

public class SpecFunctionUsingWithKeywordTestCase {

    RequestSpecification requestSpecification;

    @BeforeClass
    public void setRequestSpecification(){

        requestSpecification = with()
                .baseUri("http://localhost:3000")
                .basePath("/employees");
    }

    @Test(priority = 1)
    public void getSingleEmployee(){

        given()
                .spec(requestSpecification)
        .when()
                .get("/1")
        .then()
                .statusCode(200)
                .log()
                .body();
    }

    @Test(priority = 2)
    public void getAllEmployees(){

        given()
                .spec(requestSpecification)
        .when()
                .get()
        .then()
                .statusCode(200)
                .log()
                .body();
    }

}
