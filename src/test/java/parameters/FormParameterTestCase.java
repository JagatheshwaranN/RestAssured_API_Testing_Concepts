package parameters;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class FormParameterTestCase {

    @Test(priority = 1)
    public void formParam(){

        given()
                .formParam("_token", "dcf46697d708eab0f1de4072e97e.-2pOEJk1ULGz0dr0m6U0oa74PJxHu02P6NcuRgMQ2GE.l1N6Y-BmCuPbtpCi-e5N7uOxUO4sljvhiZ18EWZysQyRGAMm_VoVwti2lw")
                .formParam("username","Admin")
                .formParam("password", "admin123")
        .when()
                .post("https://opensource-demo.orangehrmlive.com/web/index.php/auth/validate")
        .then()
                .statusCode(302)
                .log()
                .status();
    }

}
