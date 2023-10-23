package certificates;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class TLSCertificateIssueTestCase {

    // Not Working
    @Test(priority = 1)
    public void byPassTLSCertificateIssue(){

        given()
                .relaxedHTTPSValidation("TLS")
        .when()
                .get("https://tls-v1-0.badssl.com:1010/")
        .then()
                .statusCode(200)
                .log().status();
    }

}
