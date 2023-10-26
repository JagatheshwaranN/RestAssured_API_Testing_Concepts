package serialization.jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import org.testng.annotations.Test;
import pojo.jackson.serialize.CustomSerializer;
import pojo.jackson.serialize.Devices;
import pojo.jackson.serialize.JacksonSerialize;

import java.util.List;


public class SerializationUsingJacksonSerializerTestCase {

    @Test(priority = 1)
    public void serializeUsingJacksonSerializerApproach1() throws JsonProcessingException {

        /*
            Without Jackson Custom Serializer usage, the result as below.
            {
              "name" : "John Doe",
              "email" : "johndoe@example.com",
              "skills" : [ "Java", "Python" ],
              "devices" : {
                "laptop" : "MacBook Pro",
                "mobile" : "iPhone 12"
              }
            }
        */

        JacksonSerialize jacksonSerialize = new JacksonSerialize();
        jacksonSerialize.setName("John Doe");
        jacksonSerialize.setEmail("johndoe@example.com");
        jacksonSerialize.setSkills(List.of("Java", "Python"));
        Devices devices = new Devices();
        devices.setLaptop("MacBook Pro");
        devices.setMobile("iPhone 12");
        jacksonSerialize.setDevices(devices);

        ObjectMapper objectMapper = new ObjectMapper();

        SimpleModule simpleModule = new SimpleModule();
        simpleModule.addSerializer(JacksonSerialize.class, new CustomSerializer());
        objectMapper.registerModule(simpleModule);

        String serializedJson = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(jacksonSerialize);
        System.out.println(serializedJson);
    }

    @Test(priority = 2)
    public void serializeUsingJacksonSerializerApproach2() throws JsonProcessingException {

        JacksonSerialize jacksonSerialize = new JacksonSerialize();
        jacksonSerialize.setName("John Doe");
        jacksonSerialize.setEmail("johndoe@example.com");
        jacksonSerialize.setSkills(List.of("Java", "Python"));
        Devices devices = new Devices();
        devices.setLaptop("MacBook Pro");
        devices.setMobile("iPhone 12");
        jacksonSerialize.setDevices(devices);

        ObjectMapper objectMapper = new ObjectMapper();
        String serializedJson = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(jacksonSerialize);
        System.out.println(serializedJson);
    }

}