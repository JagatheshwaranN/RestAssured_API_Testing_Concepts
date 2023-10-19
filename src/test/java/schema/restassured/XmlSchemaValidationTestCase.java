package schema.restassured;

import io.restassured.matcher.RestAssuredMatchers;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

/**
 * @restapi
 * @get
 */
public class XmlSchemaValidationTestCase {

    @Test(priority = 1)
    public void validateXmlSchema() {

        given()
        .when()
                .get("http://restapi.adequateshop.com/api/Traveler?page=1")
        .then()
                .statusCode(200)
                .assertThat()
                .body(RestAssuredMatchers.matchesXsdInClasspath("xml_schema.xsd"));
    }
}
