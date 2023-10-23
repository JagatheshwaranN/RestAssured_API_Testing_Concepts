package certificates;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class SSLCertificateIssueTestCase {

    @Test(priority = 1)
    public void byPassSSLCertificateIssue(){

        given()
                .relaxedHTTPSValidation()
        .when()
                .get("https://untrusted-root.badssl.com/")
        .then()
                .statusCode(200)
                .log().status();
    }

}
