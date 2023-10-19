package response.restassured;


import org.testng.annotations.Test;

import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;

public class ResponseValidationByHamcrestMatchersTestCase {

    @Test(priority = 1)
    public void validateResponseByHamcrestEqualTo() {

        given()
        .when()
                .get("http://localhost:3000/store")
        .then()
                .statusCode(200)
                .body("books[1].title", equalTo("The Art of Cooking"));
    }

    @Test(priority = 2)
    public void validateResponseByAssertThatAndHamcrestEqualTo() {

        given()
        .when()
                .get("http://localhost:3000/store")
        .then()
                .assertThat()
                .statusCode(200)
                .and()
                .body("books[1].title", equalTo("The Art of Cooking"));
    }

    @Test(priority = 3)
    public void validateResponseByHamcrestHasItems() {

        given()
        .when()
                .get("http://localhost:3000/store")
        .then()
                .statusCode(200)
                .body("books.title", hasItems("The Great Adventure", "The Art of Cooking"));
    }

}
