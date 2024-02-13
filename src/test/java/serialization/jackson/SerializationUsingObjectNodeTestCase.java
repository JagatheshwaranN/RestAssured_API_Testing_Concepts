package serialization.jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class SerializationUsingObjectNodeTestCase {

    @Test(priority = 1)
    public void testSerializationUsingObjectNode() throws JsonProcessingException {

        ObjectMapper objectMapper = new ObjectMapper();
        ObjectNode objectNode = objectMapper.createObjectNode();
        objectNode.put("name", "John");
        objectNode.put("job", "Tester");

        String playLoad = objectMapper.writeValueAsString(objectNode);

        given()
                .contentType("application/json")
                .body(playLoad)
        .when()
                .post("https://reqres.in/api/users")
        .then()
                .statusCode(201)
                .log().all();
    }

}
