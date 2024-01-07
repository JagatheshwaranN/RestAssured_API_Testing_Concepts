package spec;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class SpecUsingRequestSpecBuilderTestCase {

    RequestSpecification requestSpecification;

    @BeforeClass
    public void setRequestSpecificationUsingRequestSpecBuilder(){

        RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
        requestSpecification = requestSpecBuilder
                .setBaseUri("http://localhost:3000")
                .setBasePath("/employees")
                .build();

        /*
            Another way to do request specification
            =======================================
            requestSpecBuilder.setBaseUri("http://localhost:3000");
            requestSpecBuilder.setBasePath("/employees");
            RestAssured.requestSpecification = requestSpecBuilder.build();
        */
    }

    @Test(priority = 1)
    public void getSingleEmployeeUsingApproach1(){

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
    public void getSingleEmployeeUsingApproach2(){

        given(requestSpecification)
        .when()
                .get("/1")
        .then()
                .statusCode(200)
                .log()
                .body();
    }

}
