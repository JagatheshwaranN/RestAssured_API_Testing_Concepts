package deserialization.jackson_annotation;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.annotations.Test;
import pojo.jackson.deserialize.JacksonCreatorAndProperty;

public class DeserializationUsingJacksonCreatorAndPropertyTestCase {

    @Test(priority = 1)
    public void deserializeUsingJacksonCreatorAndProperty() throws JsonProcessingException {

        String sampleJson = """
                {
                   "empId" : 1,
                   "name" : "Ken",
                   "email" : "ken@test.com"
                 }""";

        ObjectMapper objectMapper = new ObjectMapper();
        JacksonCreatorAndProperty jacksonCreatorAndProperty = objectMapper.readValue(sampleJson, JacksonCreatorAndProperty.class);
        System.out.println(jacksonCreatorAndProperty.getId());
        System.out.println(jacksonCreatorAndProperty.getName());
        System.out.println(jacksonCreatorAndProperty.getEmail());
    }

}
