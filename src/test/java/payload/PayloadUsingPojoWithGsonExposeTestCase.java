package payload;

import org.testng.annotations.Test;
import pojo.Student1;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

/**
 * @restapi
 * @post
 */
public class PayloadUsingPojoWithGsonExposeTestCase {

    @Test(priority = 1)
    public void postUsingPojoWithGsonExposeAsPayload() {

        String[] courses = {"Accounts", "Commerce", "Computer Science"};
        Student1 studentData = new Student1("Adam", "Richmond", "313-456-7890", courses);

        given()
                .contentType("application/json")
                .body(studentData)
        .when()
                .post("http://localhost:3000/students")
        .then()
                .statusCode(201)
                .body("id", equalTo(4))
                .body("name", equalTo("Adam"))
                .body("location", equalTo("Richmond"))
                .body("phone", equalTo("313-456-7890"))
                .body("courses[0]", equalTo("Accounts"))
                .body("courses[1]", equalTo("Commerce"))
                .body("courses[2]", equalTo("Computer Science"))
                .header("Content-Type", "application/json; charset=utf-8")
                .log().all();


        /*
            The below code is to reset the student record with id 4 to use in other scenarios
        */
        given()
        .when()
                .delete("http://localhost:3000/students/4")
        .then()
                .statusCode(200)
                .log().all();
    }
}
