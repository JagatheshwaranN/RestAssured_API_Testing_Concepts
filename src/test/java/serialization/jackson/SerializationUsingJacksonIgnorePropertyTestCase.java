package serialization.jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.annotations.Test;
import pojo.jackson.serialize.JacksonIgnoreProperty;

import static io.restassured.RestAssured.given;

public class SerializationUsingJacksonIgnorePropertyTestCase {

    @Test(priority = 1)
    public void serializeUsingJacksonIgnoreProperty() throws JsonProcessingException {

        JacksonIgnoreProperty jacksonIgnoreProperty = new JacksonIgnoreProperty();
        jacksonIgnoreProperty.setName("Eric Bros");
        jacksonIgnoreProperty.setLocation("New Jersey");
        jacksonIgnoreProperty.setPhone("313-657-9872");

        String response =
                given()
                        .contentType("application/json")
                        .body(jacksonIgnoreProperty)
                        .when()
                        .post("http://localhost:3000/person")
                        .asPrettyString();

        ObjectMapper objectMapper = new ObjectMapper();
        JacksonIgnoreProperty person = objectMapper.readValue(response, JacksonIgnoreProperty.class);
        System.out.println(person.getId());
        System.out.println(person.getName());
        System.out.println(person.getLocation());
        System.out.println(person.getPhone());
    }

}
