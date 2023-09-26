package chaining.testng;

import com.github.javafaker.Faker;
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

        // The below code is used in tests tag level of testNG xml file
        // int id = (Integer) context.getAttribute("stud_id");

        // The below code is used across tests tage level i.e. suite level of testNG xml file
        int id = (Integer) context.getSuite().getAttribute("stud_id");

        Faker faker = new Faker();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", faker.name().firstName());
        jsonObject.put("location", faker.address().city());
        jsonObject.put("phone", faker.phoneNumber().cellPhone());
        String[] courses = {"Accounts", "Commerce", "Computer Science"};
        jsonObject.put("courses", courses);

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
