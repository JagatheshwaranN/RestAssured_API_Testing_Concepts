package response.hamcrest.json;


import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

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

    @Test(priority = 4)
    public void validateResponseByHamcrestInstanceOfApproach1(){

        RestAssured.given()
                .get("http://localhost:3000/employees/1")
                .then()
                .body("", Matchers.instanceOf(Map.class));
    }

    @Test(priority = 5)
    public void validateResponseByHamcrestInstanceOfApproach2(){

        RestAssured.given()
                .get("http://localhost:3000/addresses")
                .then()
                .body("", Matchers.instanceOf(List.class));
    }

    @Test(priority = 6)
    public void validateResponseByHamcrestInstanceOfApproach3(){

        RestAssured.given()
                .get("http://localhost:3000/students/1")
                .then()
                .body("courses", Matchers.instanceOf(List.class));
    }

}
