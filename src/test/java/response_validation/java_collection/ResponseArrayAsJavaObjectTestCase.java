package response_validation.java_collection;

import io.restassured.common.mapper.TypeRef;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class ResponseArrayAsJavaObjectTestCase {

    @Test(priority = 1)
    public void extractResponseJsonArrayAsJavaObjTest(){

        List<Map<String, Object>> response = given()
                .when()
                .get("http://localhost:3000/students")
                .as(new TypeRef<>() {
                });

        System.out.println(response.size());
        Map<String, Object> student1 = response.get(0);
        student1.entrySet().forEach(System.out::println);
        System.out.println("******************************");
        for (Map<String, Object> student : response) {
            student.entrySet().forEach(System.out::println);
        }
    }

}
