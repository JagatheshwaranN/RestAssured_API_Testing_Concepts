package cookies_headers;

import io.restassured.response.ValidatableResponse;
import org.testng.annotations.Test;

import java.util.Map;

import static io.restassured.RestAssured.given;

/**
 * @restapi
 * @get
 */
public class CookiesTestCase {

    @Test(priority = 1)
    public void getCookieInfo(){

       ValidatableResponse response =
                given()
                .when()
                       .get("https://www.google.com/")
                .then()
                       .statusCode(200);

        System.out.println(response.extract().cookie("AEC"));
    }

    @Test(priority = 2)
    public void getCookiesInfo(){

        ValidatableResponse response =
                given()
                        .when()
                        .get("https://www.google.com/")
                        .then()
                        .statusCode(200);

        Map<String, String> cookies = response.extract().cookies();

        // Approach 1
        for(String cookieName : cookies.keySet()){
            String cookieValue = response.extract().cookie(cookieName);
            System.out.println(cookieName+ " : " +cookieValue);
        }

        // Approach 2
        for(Map.Entry<String, String> cookieEntry : cookies.entrySet()){
            System.out.println(cookieEntry.getKey()+ " : "+cookieEntry.getValue());
        }
    }
}
