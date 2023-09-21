package authorization.bdd_style;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

/**
 * @restapi
 * @get
 */
public class OAuth2TestCase {

    @Test(priority = 1)
    public void validateOAuth2(){

        given()
                .auth().oauth2("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wq")
        .when()
                .get("https://api.github.com/users")
        .then()
                .statusCode(200)
                .log().body();
    }
}
