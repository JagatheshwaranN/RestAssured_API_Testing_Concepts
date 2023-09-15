package response_validation;


import io.restassured.response.ValidatableResponse;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;


public class XmlResponseValidationApproach2TestCase {

    @Test(priority = 1)
    public void validateResponseApproach2() {

        ValidatableResponse response =
                given()
                .when()
                        .get("http://restapi.adequateshop.com/api/Traveler?page=1")
                .then()
                        .statusCode(200);
        Assert.assertEquals(response.extract().statusCode(), 200);
        Assert.assertEquals(response.extract().contentType(), "application/xml; charset=utf-8");
        Assert.assertEquals(response.extract().header("Server"), "Microsoft-IIS/10.0");
        String travellerId = response.extract().body().xmlPath().get("TravelerinformationResponse.travelers.Travelerinformation[0].id").toString();
        Assert.assertEquals(travellerId, "11133");
    }
}
