package retry;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.awaitility.Awaitility;
import org.testng.annotations.Test;
import pojo.Employee1;

import java.time.Duration;

public class PostMethodWithRetryOptionTestCase {

    public static Response response =null;

    @Test(priority = 1)
    public void postMethodWithRetryType1Test(){

        Awaitility
                .await()
                .atMost(Duration.ofSeconds(30))
                .pollInterval(Duration.ofSeconds(3))
                .until(() -> postMethodWithRetryOptionType1() == 201);
    }

    @Test(priority = 2)
    public void postMethodWithRetryType2Test(){

        String url = "http://localhost:3000/employees";
        String jsonPayLoad = """
            {
                "name": "William Jones",
                "location": "Seattle",
                "phone": "313-678-7890",
                "address": "California"
              }""";

        Awaitility
                .await()
                .atMost(Duration.ofSeconds(30))
                .pollInterval(Duration.ofSeconds(3))
                .until(() -> {
                    response = postMethodWithRetryOptionType2(url, jsonPayLoad);
                    return response != null;
                });
        System.out.println(response.asString());
    }

    public int postMethodWithRetryOptionType1(){

        int randomNumber = (int) ((Math.random() * (50 - 1)) + 1);
        System.out.println("Random Number "+randomNumber);

        if(randomNumber % 2 == 0 ) {

            Employee1 employee1 = new Employee1();
            employee1.setName("Alex Jones");
            employee1.setLocation("New Jersey");
            employee1.setPhone("313-456-7890");
            employee1.setAddress("New Jersey");

            return RestAssured.given()
                    .body(employee1)
                    .contentType(ContentType.JSON)
                    .post("http://localhost:3000/employees")
                    .statusCode();

        } else {
            System.out.println("Employee creation failed");
            return 0;
        }
    }

    public Response postMethodWithRetryOptionType2(String url, String jsonPayLoad){

        int randomNumber = (int) ((Math.random() * (50 - 1)) + 1);
        System.out.println("Random Number "+randomNumber);

        if(randomNumber % 2 == 0 ) {

            return RestAssured.given()
                    .body(jsonPayLoad)
                    .contentType(ContentType.JSON)
                    .post(url);

        } else {
            System.out.println("Employee creation failed");
            return null;
        }
    }

}
