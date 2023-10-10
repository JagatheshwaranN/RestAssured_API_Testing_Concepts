package deserialization.jackson_annotation;

import com.fasterxml.jackson.databind.InjectableValues;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import org.testng.annotations.Test;
import pojo.jackson.deserialize.JacksonInjection;

import java.io.IOException;

public class DeserializationUsingJacksonInjectionTestCase {

    @Test(priority = 1)
    public void deserializeUsingJacksonInjection() throws IOException {

        String sampleJson = """
                {
                   "id" : 1,
                   "email" : "ken@test.com"
                 }""";

        InjectableValues values = new InjectableValues
                .Std().addValue(String.class, "ken");

        ObjectMapper objectMapper = new ObjectMapper();
        ObjectReader objectReader = objectMapper.reader(values);
        JacksonInjection jacksonInjection = objectReader.readValue(sampleJson, JacksonInjection.class);
        System.out.println(jacksonInjection.getId());
        System.out.println(jacksonInjection.getName());
        System.out.println(jacksonInjection.getEmail());
    }

}
