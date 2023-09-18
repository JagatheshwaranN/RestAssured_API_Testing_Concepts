package chaining;

import io.restassured.response.ValidatableResponse;
import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

/**
 * @restapi
 * @post
 */
public class CreateStudentTestCase {

    @Test(priority = 1)
    public void createStudent(ITestContext context){

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", "Adam");
        jsonObject.put("location", "Seattle");
        jsonObject.put("phone", "313-456-7890");
        String[] courses = {"Accounts", "Commerce", "Computer Science"};
        jsonObject.put("courses", courses);

        ValidatableResponse response =
        given()
                .contentType("application/json")
                .body(jsonObject.toString())
        .when()
                .post("http://localhost:3000/students")
        .then()
                .statusCode(201)
                .log().body();

        context.setAttribute("stud_id", response.extract().body().jsonPath().getInt("id"));
    }
}
