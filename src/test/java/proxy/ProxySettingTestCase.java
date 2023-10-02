package proxy;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class ProxySettingTestCase {

    @Test(priority = 1)
    public void proxySetting(){

        RestAssured
                .given()
                        .proxy("127.0.0.1", 8888)
                .when()
                        .get("http://localhost:3000/students")
                .then()
                        .statusCode(200)
                        .log()
                        .body();
    }
}
