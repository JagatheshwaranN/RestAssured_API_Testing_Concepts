package yaml;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import org.testng.annotations.Test;
import pojo.yaml.Person;
import pojo.yaml.Worker;

import java.io.File;
import java.io.IOException;

public class ReadYamlFileDataUsingJacksonTestCase {

    @Test(priority = 1)
    public void readType1YamlFileUsingJackson() {
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

    @Test(priority = 2)
    public void readType2YamlFileUsingJackson() {
        ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory());
        Worker worker;
        String filePath = System.getProperty("user.dir")+"//src//main//java//yaml//files//worker.yaml";
        try {
            worker = objectMapper.readValue(new File(filePath), Worker.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println(worker.getWorkerDetail().getFirstname());
        System.out.println(worker.getWorkerDetail().getLastname());
        System.out.println(worker.getWorkerDetail().getAge());
        System.out.println(worker.getWorkerDetail().getRating());
        System.out.println(worker.getWorkerDetail().getMarks());
        System.out.println(worker.getWorkerDetail().getBirthday());
        System.out.println(worker.getWorkerDetail().getMale());
        System.out.println(worker.getWorkerDetail().getFavNum());
        System.out.println(worker.getWorkerDetail().getHobbies());
        System.out.println(worker.getWorkerDetail().getMovies());
        System.out.println(worker.getWorkerDetail().getFriends());
        System.out.println(worker.getWorkerDetail().getSummary());
        System.out.println(worker.getWorkerDetail().getSignature());
    }

}
