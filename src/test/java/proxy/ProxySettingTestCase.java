package proxy;

import io.restassured.RestAssured;
import io.restassured.specification.ProxySpecification;
import org.testng.annotations.Test;

public class ProxySettingTestCase {

    @Test(priority = 1)
    public void proxySettingType1(){

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

    @Test(priority = 2)
    public void proxySettingType2(){
        ProxySpecification proxySpec = new ProxySpecification("localhost", 8080, "http");
        RestAssured
                .given()
                    .proxy(proxySpec)
                .when()
                    .get("http://localhost:3000/students")
                .then()
                    .statusCode(200)
                    .log()
                    .body();
    }

}
