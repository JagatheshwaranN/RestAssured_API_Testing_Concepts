package response.path;

import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

/**
 * @restapi
 * @get
 */
public class ResponseExtractUsingRestAssuredPathTestCase {

    @Test(priority = 1)
    public void responseExtractUsingRestAssuredPathApproach1Type1() {

        Response response =
                given()
                .when()
                        .get("https://reqres.in/api/users/2");

        String avatar_url = response.path("data.avatar");
        Assert.assertEquals(avatar_url, "https://reqres.in/img/faces/2-image.jpg");
    }

    @Test(priority = 2)
    public void responseExtractUsingRestAssuredPathApproach1Type2() {

        Response response =
                given()
                        .when()
                        .get("https://reqres.in/api/users/2");

        String avatar_url = response.andReturn().path("data.avatar");
        Assert.assertEquals(avatar_url, "https://reqres.in/img/faces/2-image.jpg");
    }

    @Test(priority = 3)
    public void responseExtractUsingRestAssuredPathApproach2() {

        ValidatableResponse response =
                given()
                .when()
                        .get("https://reqres.in/api/users/2")
                .then()
                        .statusCode(200);
        String bookTitle = response.extract().body().path("data.email");
        Assert.assertEquals(bookTitle, "janet.weaver@reqres.in");
    }

}
