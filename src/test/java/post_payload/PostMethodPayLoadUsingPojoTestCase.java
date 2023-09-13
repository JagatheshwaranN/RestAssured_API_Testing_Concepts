package post_payload;

import org.json.JSONObject;
import org.testng.annotations.Test;
import pojo.Student;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

/**
 * @restapi
 * @post
 */
public class PostMethodPayLoadUsingPojoTestCase {

    @Test(priority = 1)
    public void postUsingPojoAsPayload() {

       Student studentData = new Student();
       studentData.setName("Adam");
       studentData.setLocation("Richmond");
       studentData.setPhone("313-456-7890");
       String[] courses = {"Accounts", "Commerce", "Computer Science"};
       studentData.setCourses(courses);

        given()
                .contentType("application/json")
                .body(studentData)
        .when()
                .post("http://localhost:3000/students")
        .then()
                .statusCode(201)
                .body("name", equalTo("Adam"))
                .body("location", equalTo("Richmond"))
                .body("phone", equalTo("313-456-7890"))
                .body("courses[0]", equalTo("Accounts"))
                .body("courses[1]", equalTo("Commerce"))
                .body("courses[2]", equalTo("Computer Science"))
                .header("Content-Type", "application/json; charset=utf-8")
                .log().all();


        /*
            The below code is to reset the studentData with id 4 to use in other scenarios
        */
        given()
        .when()
                .delete("http://localhost:3000/students/4")
        .then()
                .statusCode(200)
                .log().all();
    }
}
