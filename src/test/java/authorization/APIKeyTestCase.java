package authorization;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

/**
 * @restapi
 * @get
 */
public class APIKeyTestCase {

    @Test(priority = 1)
    public void validateAPIKeyTestCase(){

        given()
                .headers("X-NTK-KEY", "test_gLYqwo0wftF1Ph2pTxEbWah1B0sNYU8wlEoQ6KW1")
        .when()
                .get("https://api.nettoolkit.com/v1/geo/tiles/12/1171/1566?type=raster")
        .then()
                .statusCode(200);
    }
}
