package serialization.jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.annotations.Test;
import pojo.jackson.serialize.JacksonGetter;

public class SerializationUsingJacksonGetterTestCase {

    @Test(priority = 1)
    public void serializeUsingJacksonGetter() throws JsonProcessingException {

        JacksonGetter jacksonGetter = new JacksonGetter();
        jacksonGetter.setId(1);
        jacksonGetter.setName("Ken");
        jacksonGetter.setEmail("ken@test.com");

        ObjectMapper objectMapper = new ObjectMapper();
        String serializedJson = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(jacksonGetter);
        System.out.println(serializedJson);

    }
}
