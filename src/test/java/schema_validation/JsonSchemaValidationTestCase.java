package schema_validation;

import io.restassured.module.jsv.JsonSchemaValidator;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import static io.restassured.RestAssured.given;

/**
 * @restapi
 * @get
 */
public class JsonSchemaValidationTestCase {

    @Test(priority = 1)
    public void validateJsonSchemaType1() {

        given()
        .when()
                .get("http://localhost:3000/students/1")
        .then()
                .statusCode(200)
                .assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("json_schema.json"));
    }

    @Test(priority = 2)
    public void validateJsonSchemaType2() {

        File jsonSchema = new File("src//test//resources//json_schema.json");

        given()
        .when()
                .get("http://localhost:3000/students/1")
        .then()
                .statusCode(200)
                .assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }

    @Test(priority = 3)
    public void validateJsonSchemaType3() throws FileNotFoundException {

        FileInputStream jsonSchema = new FileInputStream("src//test//resources//json_schema.json");

        given()
        .when()
                .get("http://localhost:3000/students/1")
        .then()
                .statusCode(200)
                .assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }

}
