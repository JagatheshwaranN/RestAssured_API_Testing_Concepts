package serialization.jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.testng.annotations.Test;
import pojo.jackson.serialize.JacksonRootName;

public class SerializationUsingJacksonRootNameTestCase {

    @Test(priority = 1)
    public void serializeUsingJacksonRootName() throws JsonProcessingException {

        JacksonRootName jacksonRootName = new JacksonRootName();
        jacksonRootName.setId(1);
        jacksonRootName.setName("Ken");
        jacksonRootName.setEmail("ken@test.com");

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.WRAP_ROOT_VALUE);
        String serializedJson = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(jacksonRootName);
        System.out.println(serializedJson);
    }

}
