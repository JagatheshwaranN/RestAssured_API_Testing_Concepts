package deserialization.jackson.json;

import org.testng.annotations.Test;
import pojo.jackson.deserialize.json.JacksonIgnoreUnknown;

import static io.restassured.RestAssured.given;

public class DeserializationUsingJacksonIgnoreUnknownTestCase {

    @Test(priority = 1)
    public void deserializeUsingJacksonIgnoreUnknown() {
        /*
            JacksonIgnoreUnknown is used to ignore the unknown fields in the response.
        */
        JacksonIgnoreUnknown jacksonIgnoreUnknown =
                given()
                .when()
                    .get("http://localhost:3000/person1/1")
                .then()
                    .extract()
                    .response()
                    .as(JacksonIgnoreUnknown.class);

        System.out.println(jacksonIgnoreUnknown.getId());
        System.out.println(jacksonIgnoreUnknown.getName());
        System.out.println(jacksonIgnoreUnknown.getLocation());
        System.out.println(jacksonIgnoreUnknown.getPhone());
    }

}
