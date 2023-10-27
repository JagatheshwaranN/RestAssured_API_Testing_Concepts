package deserialization.jackson.xml;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.testng.annotations.Test;
import pojo.jackson.deserialize.xml.Employee;
import pojo.jackson.deserialize.xml.Employees;

import java.io.File;
import java.io.IOException;

public class DeserializeXmlFileUsingJacksonTestCase {

    @Test(priority = 1)
    public void deserializeXmlFile() throws IOException {

        ObjectMapper objectMapper = new XmlMapper();
        /*
            // Employees employees = objectMapper.readValue(StringUtils.toEncodedString(
            // Files.readAllBytes(Paths.get("src/test/resources/employees.xml")),
            // StandardCharsets.UTF_8), Employees.class);
        */
        Employees employees = objectMapper.readValue(
                new File("src/test/resources/employees.xml"), Employees.class);

        Employee employee1 = employees.getEmployee()[0];
        System.out.println("Employee 1 Id        : " + employee1.getId());
        System.out.println("Employee 1 FirstName : " + employee1.getFirstname());
        System.out.println("Employee 1 LastName  : " + employee1.getLastname());
        System.out.println("Employee 1 Age       : " + employee1.getAge());
        Employee employee2 = employees.getEmployee()[1];
        System.out.println("Employee 2 Id        : " + employee2.getId());
        System.out.println("Employee 2 FirstName : " + employee2.getFirstname());
        System.out.println("Employee 2 LastName  : " + employee2.getLastname());
        System.out.println("Employee 2 Age       : " + employee2.getAge());
    }

}
