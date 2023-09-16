package schema_validation;

import io.restassured.module.jsv.JsonSchemaValidator;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

/**
 * @restapi
 * @get
 */
public class JsonSchemaValidationTestCase {

    @Test(priority = 1)
    public void validateJsonSchema() {

        given()
        .when()
                .get("http://localhost:3000/students/1")
        .then()
                .statusCode(200)
                .assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("json_schema.json"));
    }
}
