package deserialization.jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.annotations.Test;
import pojo.jackson.deserialize.JacksonSetter;

public class DeserializationUsingJacksonSetterTestCase {

    @Test(priority = 1)
    public void deserializeUsingJacksonSetter() throws JsonProcessingException {

        String sampleJson = """
                {
                   "empId" : 1,
                   "name" : "Ken",
                   "email" : "ken@test.com"
                 }""";

        ObjectMapper objectMapper = new ObjectMapper();
        JacksonSetter jacksonSetter = objectMapper.readValue(sampleJson, JacksonSetter.class);
        System.out.println(jacksonSetter.getId());
    }

}
