package response.time;

import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.lessThan;

public class ResponseTimeTestCase {

    @Test(priority = 1)
    public void validateResponseTimeApproach1() {

        Response response =
        given().
                when()
                .get("https://reqres.in/api/users/2");
        long time = response.time();
        long getTime = response.getTime();
        System.out.println("Response Time from Time     : " + time);
        System.out.println("Response Time from Get Time : " + getTime);
    }

    @Test(priority = 2)
    public void validateResponseTimeApproach2() {

        Response response =
                given().
                        when()
                        .get("https://reqres.in/api/users/2");

        long time = response.timeIn(TimeUnit.SECONDS);
        long getTime = response.getTimeIn(TimeUnit.SECONDS);
        System.out.println("Response Time from Time     : " + time);
        System.out.println("Response Time from Get Time : " + getTime);
    }

    @Test(priority = 3)
    public void verifyValidatableResponseTimeApproach1() {

        ValidatableResponse response =
                given().
                when()
                        .get("https://reqres.in/api/users/2")
                .then();
        long time = response.extract().time();
        long getTime = response.extract().response().getTime();
        System.out.println("Response Time from Time     : " + time);
        System.out.println("Response Time from Get Time : " + getTime);
    }

    @Test(priority = 4)
    public void verifyValidatableResponseTimeApproach2() {

        ValidatableResponse response =
                given().
                when()
                        .get("https://reqres.in/api/users/2")
                .then();
        long time = response.extract().timeIn(TimeUnit.SECONDS);
        long getTime = response.extract().response().getTimeIn(TimeUnit.SECONDS);
        System.out.println("Response Time from Time     : " + time);
        System.out.println("Response Time from Get Time : " + getTime);
    }

    @Test(priority = 5)
    public void verifyValidatableResponseTimeByHamcrestMatchers() {

        ValidatableResponse response =
                given().
                        when()
                        .get("https://reqres.in/api/users/2")
                        .then()
                        .time(lessThan(2000L));
        System.out.println("Response  : " + response.extract().asString());
    }

}
