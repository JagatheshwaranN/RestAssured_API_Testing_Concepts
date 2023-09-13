package post_payload;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;
import pojo.Student;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

/**
 * @restapi
 * @post
 */
public class PostMethodPayLoadUsingExternalJsonTestCase {

    @Test(priority = 1)
    public void postUsingExternalJsonAsPayload() {

        JSONObject studentData;

        try (FileReader fileReader = new FileReader("src//test//resources//student_payload.json")){
            JSONTokener jsonTokener = new JSONTokener(fileReader);
            studentData = new JSONObject(jsonTokener);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        given()
                .contentType("application/json")
                .body(studentData.toString())
        .when()
                .post("http://localhost:3000/students")
        .then()
                .statusCode(201)
                .body("name", equalTo("Adam Smith"))
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
