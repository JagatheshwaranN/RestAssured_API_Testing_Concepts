package response_validation.pojo;

import org.testng.Assert;
import org.testng.annotations.Test;
import pojo.Student;

import java.util.Arrays;

import static io.restassured.RestAssured.given;

public class ResponseValidationUsingPojoClassTestCase {

    @Test(priority = 1)
    public void validateResponseUsingPojo(){

        Student response =
                given()
                .when()
                        .get("http://localhost:3000/students/1")
                        .as(Student.class);

        Assert.assertEquals(response.getName(), "John Doe");
        Assert.assertEquals(response.getLocation(), "New York");
        Assert.assertEquals(response.getPhone(), "123-456-7890");
        Assert.assertEquals(Arrays.stream(response.getCourses()).count(), 3);

    }
}
