package response.root;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

public class ResponseValidationWithRootPathTestCase {

    @Test(priority = 1)
    public void validateResponseUsingRootApproach1(){

        given()
        .when()
                .get("http://localhost:3000/country")
        .then()
                .rootPath("response.country_info.details")
                .body("capital", is("Washington, D.C."));
    }

    @Test(priority = 2)
    public void validateResponseUsingRootApproach2(){

        given()
        .when()
                .get("http://localhost:3000/country")
        .then()
                .rootPath("response.country_info.details")
                .body("capital", is("Washington, D.C."))
                .detachRootPath("details")
                .body("country", is("United States"));
    }

}
