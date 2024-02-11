package filter;

import io.restassured.filter.log.LogDetail;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.PrintStream;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class FilterLogToFileTestCase {

    @Test(priority = 1)
    public void filterLogToFile() throws FileNotFoundException {

        PrintStream printStream = new PrintStream("src/test/java/filter/logs/req-res.log");
        given()
                .filter(new RequestLoggingFilter(LogDetail.HEADERS, printStream))
                .filter(new ResponseLoggingFilter(LogDetail.BODY, printStream))
        .when()
                .get("https://reqres.in/api/users/2")
        .then()
                .statusCode(200)
                .body("data.id", equalTo(2));
    }

}
