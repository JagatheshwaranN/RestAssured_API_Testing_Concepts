package post_payload;


import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

/**
 * @restapi
 * @post
 */
public class PostMethodPayLoadUsingHashMapTestCase {

    @Test(priority = 1)
    public void postUsingHashMapAsPayload() {

        HashMap<String, Object> studentData = new HashMap<>();
        studentData.put("name", "Adam");
        studentData.put("location", "Richmond");
        studentData.put("phone", "313-456-7890");
        String[] courses = {"Accounts", "Commerce", "Computer Science"};
        studentData.put("courses", courses);

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
