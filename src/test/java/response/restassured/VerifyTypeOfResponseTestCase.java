package response.restassured;

import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

/**
 * @restapi
 * @get
 */
public class VerifyTypeOfResponseTestCase {

    @Test(priority = 1)
    public void validateObjectResponse(){

        RestAssured.given()
                .get("http://localhost:3000/employees/1")
                .then()
                .body("", Matchers.instanceOf(Map.class));
    }

    @Test(priority = 2)
    public void validateArrayResponse(){

        RestAssured.given()
                .get("http://localhost:3000/addresses")
                .then()
                .body("", Matchers.instanceOf(List.class));
    }

    @Test(priority = 3)
    public void validatePartialResponse(){

        RestAssured.given()
                .get("http://localhost:3000/students/1")
                .then()
                .body("courses", Matchers.instanceOf(List.class));
    }

}
