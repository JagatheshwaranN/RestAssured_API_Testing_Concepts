package serialization.jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.annotations.Test;
import pojo.jackson.serialize.JacksonRawValue;

public class SerializationUsingJacksonRawValueTestCase {

    @Test(priority = 1)
    public void serializeUsingJacksonRawValue() throws JsonProcessingException {

        JacksonRawValue jacksonRawValue = new JacksonRawValue();
        jacksonRawValue.setId(1);
        jacksonRawValue.setName("Ken");
        jacksonRawValue.setEmail("ken@test.com");

        ObjectMapper objectMapper = new ObjectMapper();
        String serializedJson = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(jacksonRawValue);
        System.out.println(serializedJson);
    }

}
