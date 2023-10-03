package schema_validation.restassured;

import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import org.apache.commons.io.FileUtils;
import org.hamcrest.MatcherAssert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

import static io.restassured.RestAssured.given;

/**
 * @restapi
 * @get
 */
public class JsonSchemaValidationUsingHamcrestTestCase {

    @Test(priority = 1)
    public void validateJsonSchemaUsingHamcrest() {

        File jsonSchema = new File("src//test//resources//json_schema.json");

        Response response =
                given()
                .when()
                        .get("http://localhost:3000/students/1");

        String responseString = response.asString();
        MatcherAssert.assertThat(responseString, JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }

    @Test(priority = 2)
    public void validateJsonSchemaFromJsonFile() throws IOException {

        File inputJson = new File("src//test//resources//student_schema.json");
        String inputJsonString = FileUtils.readFileToString(inputJson, Charset.defaultCharset());
        File jsonSchema = new File("src//test//resources//json_schema.json");
        MatcherAssert.assertThat(inputJsonString, JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }

}
