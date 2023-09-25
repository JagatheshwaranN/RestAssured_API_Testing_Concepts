package response_validation;

import io.restassured.common.mapper.TypeRef;
import org.testng.annotations.Test;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class ResponseExtractionAsJavaObjectTestCase {

    @Test(priority = 1)
    public void extractResponseAsJavaObjTest(){

        Map<String, Object> response =
                given()
                .when()
                        .get("http://localhost:3000/students/1")
                        .as(new TypeRef<Map<String, Object>>() {});

        String name = (String) response.get("name");
        System.out.println(name);
        response.keySet().forEach(System.out::println);
        response.entrySet().forEach(System.out::println);
    }

}
