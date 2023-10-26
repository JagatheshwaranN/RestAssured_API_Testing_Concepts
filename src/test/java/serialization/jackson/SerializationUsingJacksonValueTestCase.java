package serialization.jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.annotations.Test;
import pojo.jackson.serialize.JacksonValue;

public class SerializationUsingJacksonValueTestCase {

    @Test(priority = 1)
    public void serializeUsingJacksonValue() throws JsonProcessingException {

        JacksonValue jacksonValue = new JacksonValue();
        jacksonValue.setId(1);
        jacksonValue.setName("Ken");
        jacksonValue.setEmail("ken@test.com");

        ObjectMapper objectMapper = new ObjectMapper();
        String serializedJson = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(jacksonValue);
        System.out.println(serializedJson);
    }

}
