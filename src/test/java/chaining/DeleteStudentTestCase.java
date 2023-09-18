package chaining;

import io.restassured.response.ValidatableResponse;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

/**
 * @restapi
 * @delete
 */
public class DeleteStudentTestCase {

    @Test(priority = 1)
    public void deleteStudent(ITestContext context){

        // The below code is used in tests tag level of testNG xml file
        // int id = (Integer) context.getAttribute("stud_id");

        // The below code is used across tests tage level i.e. suite level of testNG xml file
        int id = (Integer) context.getSuite().getAttribute("stud_id");

        ValidatableResponse response =
                given()
                        .pathParam("student_id", id)
                .when()
                        .delete("http://localhost:3000/students/{student_id}")
                .then()
                        .log().body();

        Assert.assertEquals(response.extract().statusCode(), 200);
    }
}
