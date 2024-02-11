package filter;

import io.restassured.filter.log.LogDetail;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class FilterTestCase {

    @Test(priority = 1)
    public void filter(){
        given()
                .filter(new RequestLoggingFilter(LogDetail.HEADERS))
                .filter(new ResponseLoggingFilter(LogDetail.BODY))
        .when()
                .get("https://reqres.in/api/users/2")
        .then()
                .statusCode(200)
                .body("data.id", equalTo(2));
    }

}
