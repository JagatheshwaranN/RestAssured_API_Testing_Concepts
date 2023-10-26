package serialization.jackson;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.annotations.Test;
import pojo.jackson.serialize.JacksonIgnore;

import java.io.IOException;

public class SerializationUsingJacksonIgnoreTestCase {

    @Test(priority = 1)
    public void serializeUsingJacksonIgnore() throws IOException {

        JacksonIgnore jacksonIgnore = new JacksonIgnore();
        jacksonIgnore.setId(1);
        jacksonIgnore.setName("ken");
        jacksonIgnore.setEmail("ken@test.com");

        ObjectMapper objectMapper = new ObjectMapper();
        String serializedJson = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(jacksonIgnore);
        System.out.println(serializedJson);
    }

}
