package deserialization.jackson_annotation;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.annotations.Test;
import pojo.jackson.deserialize.JacksonAnySetter;

public class DeserializationUsingJacksonAnySetterTestCase {

    @Test(priority = 1)
    public void deserializeUsingJacksonAnySetter() throws JsonProcessingException {

        String sampleJson = """
                {
                  "address" : "USA",
                  "phone" : "313-1234567",
                  "name" : "David",
                  "location" : "New Jersey",
                  "id" : 1
                }""";

        ObjectMapper objectMapper = new ObjectMapper();
        JacksonAnySetter jacksonAnySetter = objectMapper.readValue(sampleJson, JacksonAnySetter.class);
        System.out.println(jacksonAnySetter.getEmployee());
    }

}
