package response.json_path.restassured;

import io.restassured.path.json.JsonPath;
import io.restassured.response.ValidatableResponse;
import org.testng.Assert;
import org.testng.annotations.Test;
import pojo.Employee1;

import static io.restassured.RestAssured.given;

/**
 * @restapi
 * @get
 */
public class ResponseExtractUsingRestAssuredJsonPathTestCase {

    @Test(priority = 1)
    public void responseExtractUsingRestAssuredJsonPathApproach1() {

        String response =
                given()
                .when()
                        .get("http://localhost:3000/employees/1")
                        .asPrettyString();

        // We can even not choose to give $ and keep it as empty string.
        // In case of empty string also, it will provide the same result.
        Employee1 emp1 = JsonPath.from(response).getObject("$", Employee1.class);
        System.out.println(emp1.getId());
        System.out.println(emp1.getName());
        System.out.println(emp1.getLocation());
        System.out.println(emp1.getPhone());
        System.out.println(emp1.getAddress());
    }

    @Test(priority = 2)
    public void responseExtractUsingRestAssuredJsonPathApproach2() {

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
