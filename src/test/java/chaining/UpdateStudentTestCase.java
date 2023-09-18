package chaining;

import io.restassured.response.ValidatableResponse;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

/**
 * @restapi
 * @put
 */
public class UpdateStudentTestCase {

    @Test(priority = 1)
    public void updateStudent(ITestContext context){

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", "Adam Smith");
        jsonObject.put("location", "Seattle");
        jsonObject.put("phone", "313-456-7890");
        String[] courses = {"Accounts", "Commerce", "Computer Science"};
        jsonObject.put("courses", courses);

        int id = (Integer) context.getAttribute("stud_id");

        ValidatableResponse response =
                given()
                        .pathParam("student_id", id)
                        .contentType("application/json")
                        .body(jsonObject.toString())
                .when()
                        .put("http://localhost:3000/students/{student_id}")
                .then()
                        .statusCode(200)
                        .log().body();

        Assert.assertEquals((Integer) response.extract().body().jsonPath().get("id"), id);
    }
}
