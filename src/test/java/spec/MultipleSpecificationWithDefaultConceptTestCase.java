package spec;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.with;
import static io.restassured.RestAssured.get;

public class MultipleSpecificationWithDefaultConceptTestCase {

    RequestSpecification requestSpec;

    @BeforeClass
    public void setRequestSpecification(){

        requestSpec = with()
                .baseUri("http://localhost:3000")
                .basePath("/employees");
        RestAssured.requestSpecification = requestSpec;
    }

    @Test(priority = 1)
    public void getSingleEmployee(){

        given()
        .when()
                .get("/1")
        .then()
                .statusCode(200)
                .log()
                .body();
    }

    @Test(priority = 2)
    public void getSingleEmployeeType2(){

                get("/1")
                .then()
                .statusCode(200)
                .log()
                .body();
    }

    @Test(priority = 2)
    public void getAllEmployees(){

        given()
        .when()
                .get()
        .then()
                .statusCode(200)
                .log()
                .body();
    }

    @Test(priority = 3)
    public void createAnEmployee(){

        String payload = """
                  {
                    "name": "John Williams",
                    "location": "New Jersey",
                    "phone": "123-456-7890",
                    "address": "New York"
                  }
                """;
        RequestSpecification requestSpecification =
                given()
                        .baseUri("http://localhost:3000")
                        .basePath("/employees")
                        .contentType(ContentType.JSON)
                        .body(payload);

        given()
                .spec(requestSpecification)
        .when()
                .post()
        .then()
                .statusCode(201)
                .log()
                .body();
    }

}
