package response_validation;

import io.restassured.path.xml.XmlPath;
import io.restassured.response.ValidatableResponse;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class XmlArrayResponseValidationTestCase {

    @Test(priority = 1)
    public void arrayResponseValidation() {

        ArrayList<String> travellerIds = new ArrayList<>();
        travellerIds.add("11133");
        travellerIds.add("11134");
        travellerIds.add("11135");
        travellerIds.add("11136");
        travellerIds.add("11137");
        travellerIds.add("11138");
        travellerIds.add("11139");
        travellerIds.add("11140");
        travellerIds.add("11142");
        travellerIds.add("11143");

        ValidatableResponse response =
        given()
        .when()
                .get("http://restapi.adequateshop.com/api/Traveler?page=1")
        .then()
                .statusCode(200);

        XmlPath xmlPath = new XmlPath(response.extract().asString());
        List<String> travellersInfo = xmlPath.getList("TravelerinformationResponse.travelers.Travelerinformation.id");
        for(int i = 0; i < travellersInfo.size(); i++){
            System.out.println(travellersInfo.get(i));
            Assert.assertEquals(travellersInfo.get(i), travellerIds.get(i));
        }
    }
}
