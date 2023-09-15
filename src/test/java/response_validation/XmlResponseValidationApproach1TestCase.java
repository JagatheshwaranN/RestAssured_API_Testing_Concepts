package response_validation;


import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

/**
 * @restapi
 * @get
 */
public class XmlResponseValidationApproach1TestCase {

    @Test(priority = 1)
    public void validateResponseApproach1() {

        given()
        .when()
                .get("http://restapi.adequateshop.com/api/Traveler?page=1")
        .then()
                .statusCode(200)
                .body("TravelerinformationResponse.page", equalTo("1"));
    }
}
