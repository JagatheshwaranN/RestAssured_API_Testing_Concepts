package response_validation;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class ResponseDynamicObjectAsJavaObjectTestCase {

    @Test(priority = 1)
    public void extractResponseJsonObjectAsJavaObjTest(){

        Response response = given()
                .when()
                .get("http://localhost:3000/students");
        Object responseObject = response.as(Object.class);

        if(responseObject instanceof List){
            List responseAsList = (List)responseObject;
            System.out.println(responseAsList.size());
        }
        if(responseObject instanceof Map){
            Map responseAsMap = (Map)responseObject;
            responseAsMap.entrySet().forEach(System.out::println);
        }
    }

}
