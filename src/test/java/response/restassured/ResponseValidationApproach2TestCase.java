package response.restassured;


import io.restassured.response.ValidatableResponse;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;


public class ResponseValidationApproach2TestCase {

    @Test(priority = 1)
    public void validateResponseApproach2() {

        ValidatableResponse response =
                given()
                .when()
                        .get("http://localhost:3000/store")
                .then()
                        .statusCode(200);
        Assert.assertEquals(response.extract().statusCode(), 200);
        Assert.assertEquals(response.extract().contentType(), "application/json; charset=utf-8");
        Assert.assertEquals(response.extract().header("Connection"), "keep-alive");
        String bookTitle = response.extract().body().jsonPath().get("books[1].title").toString();
        Assert.assertEquals(bookTitle, "The Art of Cooking");
    }
}
