package response_validation;


import org.testng.annotations.Test;

import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;

public class ResponseValidationApproach1TestCase {

    @Test(priority = 1)
    public void validateResponseApproach1() {

        given()
                .when()
                .get("http://localhost:3000/store")
                .then()
                .statusCode(200)
                .body("books[1].title", equalTo("The Art of Cooking"));

    }
}
