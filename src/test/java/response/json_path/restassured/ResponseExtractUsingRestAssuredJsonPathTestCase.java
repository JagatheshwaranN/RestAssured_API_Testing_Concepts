package response.json_path.restassured;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.testng.Assert;
import org.testng.annotations.Test;
import pojo.Employee1;

import java.util.List;

import static io.restassured.RestAssured.given;
import static io.restassured.path.json.JsonPath.from;

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

    @Test(priority = 3)
    public void responseExtractAsListUsingRestAssuredJsonPath() {

        Response response =
                given()
                        .when()
                        .get("http://localhost:3000/store");

        String responseString = response.asString();
        List<String> authors = from(responseString).getList("books.author");
        System.out.println("Size of author's list : "+authors.size());
        authors.forEach(System.out::println);
    }

    @Test(priority = 4)
    public void responseExtractAsListUsingRestAssuredJsonPathWithGroovy() {

        Response response =
                given()
                        .when()
                        .get("http://localhost:3000/store");

        String responseString = response.asString();
        List<String> authors = from(responseString).getList("books.findAll{it.title.length()>18}.title");
        System.out.println("Size of author's list : "+authors.size());
        authors.forEach(System.out::println);
    }

    @Test(priority = 5)
    public void responseExtractUsingRestAssuredJsonPathWithRoot() {

        Response response =
                given()
                        .when()
                        .get("http://localhost:3000/country");

        String responseString = response.asString();
        JsonPath jsonPath = new JsonPath(responseString).setRootPath("response.country_info.details");
        String currency = jsonPath.get("currency");
        System.out.println(currency);
    }

}
