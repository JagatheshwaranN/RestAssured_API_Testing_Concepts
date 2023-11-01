package yaml;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import org.testng.annotations.Test;
import pojo.yaml.Person;

import java.io.File;
import java.io.IOException;

public class ReadYamlFileDataUsingJacksonTestCase {

    @Test(priority = 1)
    public void readYamlFileUsingJackson() {
        ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory());
        Person person;
        String filePath = System.getProperty("user.dir")+"//src//main//java//yaml//files//person.yaml";
        try {
            person = objectMapper.readValue(new File(filePath), Person.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println(person.getName());
        System.out.println(person.getAge());
        System.out.println(person.getLocation().getCity());
        System.out.println(person.getLocation().getState());
        System.out.println(person.getLocation().getZipcode());
        System.out.println(person.getLocation().getCountry());
        person.getRoles().forEach(System.out::println);
    }

}
