package response.restassured;


import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

/**
 * @restapi
 * @get
 */
public class XmlResponseByHamcrestMatchersTestCase {

    @Test(priority = 1)
    public void validateResponseByHamcrestEqualToApproach1() {

        given()
        .when()
                .get("http://restapi.adequateshop.com/api/Traveler?page=1")
        .then()
                .statusCode(200)
                .body("TravelerinformationResponse.page", equalTo("1"))
                .body("TravelerinformationResponse.totalrecord", equalTo("11605"));
    }

    @Test(priority = 2)
    public void validateResponseByHamcrestEqualToApproach2() {

        given()
        .when()
                .get("http://restapi.adequateshop.com/api/Traveler?page=1")
        .then()
                .statusCode(200)
                .body("TravelerinformationResponse.travelers.Travelerinformation[0].text()", equalTo("11133DeveloperDeveloper12@gmail.comUSA0001-01-01T00:00:00"));
    }

}