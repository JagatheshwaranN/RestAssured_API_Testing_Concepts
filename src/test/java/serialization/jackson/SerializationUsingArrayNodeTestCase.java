package serialization.jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class SerializationUsingArrayNodeTestCase {

    @Test(priority = 1)
    public void testSerializationUsingArrayNode() throws JsonProcessingException {

        ObjectMapper objectMapper = new ObjectMapper();
        ObjectNode objectNode1 = objectMapper.createObjectNode();
        objectNode1.put("name", "Jenni");
        ObjectNode objectNode2 = objectMapper.createObjectNode();
        objectNode2.put("name", "Erick");
        ArrayNode arrayNode = objectMapper.createArrayNode();
        arrayNode.add(objectNode1);
        arrayNode.add(objectNode2);

        String playLoad = objectMapper.writeValueAsString(arrayNode);

        given()
                .contentType("application/json")
                .body(playLoad)
                .log().body()
        .when()
                .post("https://b081e423-562e-43f3-9521-f956214a87d7.mock.pstmn.io/add/worker")
        .then()
                .statusCode(201)
                .log().body();
    }

}
