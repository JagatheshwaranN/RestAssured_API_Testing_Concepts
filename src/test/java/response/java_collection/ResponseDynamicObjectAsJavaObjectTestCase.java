package response.java_collection;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class ResponseDynamicObjectAsJavaObjectTestCase {

    @Test(priority = 1)
    public void extractResponseDynamicObjectAsJavaObjTest(){

        Response response = given()
                .when()
                .get("http://localhost:3000/students");
        Object responseObject = response.as(Object.class);

        if(responseObject instanceof List<?> responseAsList){
            System.out.println(responseAsList.size());
        }
        if(responseObject instanceof Map<?,?> responseAsMap){
            responseAsMap.entrySet().forEach(System.out::println);
        }
    }

}
