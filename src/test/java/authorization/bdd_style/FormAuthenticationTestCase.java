package authorization.bdd_style;

import io.restassured.RestAssured;
import io.restassured.authentication.FormAuthConfig;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.session.SessionFilter;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class FormAuthenticationTestCase {

    @Test
    public void formAuthentication() {

        RestAssured.requestSpecification = new RequestSpecBuilder()
                .setBaseUri("https://localhost:8443")
                .setRelaxedHTTPSValidation()
                .build();

        SessionFilter sessionFilter = new SessionFilter();

        given()
                .auth().form("dan", "dan123", new FormAuthConfig("/signin", "txtUsername", "txtPassword").withAdditionalField("_csrf"))
                .filter(sessionFilter)
                .log()
                .all()
        .when()
                .get("/login")
        .then()
                .assertThat()
                .statusCode(200)
                .log()
                .all();

        System.out.println("JSESSION_ID = "+sessionFilter.getSessionId());

        System.out.println("==========================================================================");

        given()
                .sessionId(sessionFilter.getSessionId())
        .when()
                .get("/profile/index")
        .then()
                .statusCode(200)
                .log()
                .all()
                .body("html.body.div.p", equalTo("This is User Profile\\Index. Only authenticated people can see this"));
    }

}
