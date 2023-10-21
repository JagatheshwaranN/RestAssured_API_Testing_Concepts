package cookies;

import io.restassured.http.Cookie;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

/**
 * @restapi
 * @get
 */
public class CookieDetailedInformationTestCase {

    @Test(priority = 1)
    public void getDetailedCookieInfoFromResponse(){

        Response response =
                given()
                .when()
                        .get("https://www.google.com/");

        Cookie cookie = response.getDetailedCookie("AEC");

        System.out.println("Cookie Name : " + cookie.getName());
        if(cookie.hasValue()) {
            System.out.println("Cookie Value      : " + cookie.getValue());
        }
        if(cookie.hasDomain()) {
            System.out.println("Cookie Domain     : " + cookie.getDomain());
        }
        if(cookie.hasPath()) {
            System.out.println("Cookie Path       : " + cookie.getPath());
        }
        if(cookie.hasComment()) {
            System.out.println("Cookie Comment    : " + cookie.getComment());
        }
        if(cookie.hasExpiryDate()) {
            System.out.println("Cookie ExpiryDate : " + cookie.getExpiryDate());
        }
        if(cookie.hasMaxAge()) {
            System.out.println("Cookie MaxAge     : " + cookie.getMaxAge());
        }
        if(cookie.hasVersion()) {
            System.out.println("Cookie Version    : " + cookie.getVersion());
        }
        if(cookie.hasSameSite()) {
            System.out.println("Cookie SameSite   : " + cookie.getSameSite());
        }
        System.out.println("Cookie Is Http    : " + cookie.isHttpOnly());
        System.out.println("Cookie Is Secured : " + cookie.isSecured());
    }

    @Test(priority = 2)
    public void getDetailedCookieInfoFromValidatableResponse(){

        ValidatableResponse response =
                given()
                .when()
                        .get("https://www.google.com/")
                .then()
                        .statusCode(200);

        Cookie cookie = response.extract().detailedCookie("ACE");

        System.out.println("Cookie Name : " + cookie.getName());
        if(cookie.hasValue()) {
            System.out.println("Cookie Value      : " + cookie.getValue());
        }
        if(cookie.hasDomain()) {
            System.out.println("Cookie Domain     : " + cookie.getDomain());
        }
        if(cookie.hasPath()) {
            System.out.println("Cookie Path       : " + cookie.getPath());
        }
        if(cookie.hasComment()) {
            System.out.println("Cookie Comment    : " + cookie.getComment());
        }
        if(cookie.hasExpiryDate()) {
            System.out.println("Cookie ExpiryDate : " + cookie.getExpiryDate());
        }
        if(cookie.hasMaxAge()) {
            System.out.println("Cookie MaxAge     : " + cookie.getMaxAge());
        }
        if(cookie.hasVersion()) {
            System.out.println("Cookie Version    : " + cookie.getVersion());
        }
        if(cookie.hasSameSite()) {
            System.out.println("Cookie SameSite   : " + cookie.getSameSite());
        }
        System.out.println("Cookie Is Http    : " + cookie.isHttpOnly());
        System.out.println("Cookie Is Secured : " + cookie.isSecured());
    }

}
