package response.hamcrest.xml;


import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

/**
 * @restapi
 * @get
 */
public class XmlResponseValidationByHamcrestMatchersTestCase {

    @Test(priority = 1)
    public void validateResponseByHamcrestEqualToApproach1() {

        given()
        .when()
                .get("http://restapi.adequateshop.com/api/Traveler?page=1")
        .then()
                .statusCode(200)
                .body("TravelerinformationResponse.page", equalTo("1"));
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

    @Test(priority = 3)
    public void validateResponseByHamcrestHasXpathApproach1() {

        given()
        .when()
                .get("http://restapi.adequateshop.com/api/Traveler?page=1")
        .then()
                .statusCode(200)
                .body(hasXPath("/TravelerinformationResponse/page"),containsString("1"));

    }

    @Test(priority = 4)
    public void validateResponseByHamcrestHasXpathApproach2() {

        given()
                .when()
                .get("http://restapi.adequateshop.com/api/Traveler?page=1")
                .then()
                .statusCode(200)
                .body(hasXPath("/TravelerinformationResponse/page[text()='1']"));

    }

}