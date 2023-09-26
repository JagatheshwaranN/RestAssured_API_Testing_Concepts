package chaining.testng;

import com.github.javafaker.Faker;
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

        Faker faker = new Faker();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", faker.name().firstName());
        jsonObject.put("location", faker.address().city());
        jsonObject.put("phone", faker.phoneNumber().cellPhone());
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

        // The below code is used in tests tag level of testNG xml file
        // context.setAttribute("stud_id", response.extract().body().jsonPath().getInt("id"));

        // The below code is used across tests tage level i.e. suite level of testNG xml file
        context.getSuite().setAttribute("stud_id", response.extract().body().jsonPath().getInt("id"));
    }
}
