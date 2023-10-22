package cookies;

import io.restassured.http.Cookie;
import io.restassured.http.Cookies;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class SetCookiesTestCase {

    @Test(priority = 1)
    public void setCookieInRequest(){

        given().
                cookie("test", "123")
        .when()
                .get("http://www.example.com/");
    }

    @Test(priority = 2)
    public void setCookiesInRequest(){

        Cookie cookie1 = new Cookie.Builder("test", "123").setDomain("/").setSecured(true).build();
        Cookie cookie2 = new Cookie.Builder("auto", "345").setDomain("/").setSecured(true).build();
        Cookies cookies = new Cookies(cookie1, cookie2);
        given().
                cookies(cookies)
        .when()
                .get("http://www.example.com/");

    }

}
