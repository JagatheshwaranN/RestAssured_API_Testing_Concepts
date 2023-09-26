package chaining.testng;

import io.restassured.response.ValidatableResponse;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;


/**
 * @restapi
 * @get
 */
public class GetStudentTestCase {

    @Test(priority = 1)
    public void getStudent(ITestContext context){

        // The below code is used in tests tag level of testNG xml file
        // int id = (Integer) context.getAttribute("stud_id");

        // The below code is used across tests tage level i.e. suite level of testNG xml file
        int id = (Integer) context.getSuite().getAttribute("stud_id");

        ValidatableResponse response =
                given()
                        .pathParam("student_id", id)
                .when()
                        .get("http://localhost:3000/students/{student_id}")
                .then()
                        .statusCode(200)
                        .log().body();

        Assert.assertEquals((Integer) response.extract().body().jsonPath().get("id"), id);
    }
}
