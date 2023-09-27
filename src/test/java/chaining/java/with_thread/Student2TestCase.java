package chaining.java.with_thread;

import com.github.javafaker.Faker;
import io.restassured.response.ValidatableResponse;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

/**
 * @restapi
 * @datashare
 */
public class Student2TestCase {

    @Test(priority = 1)
    public void createStudent(){

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
                .assertThat()
                .statusCode(201)
                .log().body();

        int stud_id = response.extract().body().jsonPath().getInt("id");
        ThreadLocalDataStore.setDataMap(Constants.STUDENT_ID, stud_id);
        System.out.println("Thread - "+Thread.currentThread().getName()+" has created id "+stud_id);
    }

    @Test(priority = 2)
    public void getStudent(){

        int id = (Integer) ThreadLocalDataStore.getDataMap(Constants.STUDENT_ID);
        System.out.println("Thread - "+Thread.currentThread().getName()+" has retrieved id "+id);
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

    @Test(priority = 3)
    public void deleteStudent(){

        int id = (Integer) ThreadLocalDataStore.getDataMap(Constants.STUDENT_ID);
        System.out.println("Thread - "+Thread.currentThread().getName()+" has retrieved id "+id);
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
