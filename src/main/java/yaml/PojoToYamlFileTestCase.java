package yaml;

import org.testng.annotations.Test;
import org.yaml.snakeyaml.Yaml;
import pojo.yaml.Address;
import pojo.yaml.Employee;

import java.io.FileWriter;
import java.io.IOException;

public class PojoToYamlFileTestCase {

    @Test(priority = 1)
    public void pojoToYamlFile() {
        Yaml yaml = new Yaml();
        String filePath = System.getProperty("user.dir")+"//src//main//java//yaml//files//yamlFileFromPojo.yaml";
        try {
            yaml.dump(getEmployee(), new FileWriter(filePath));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Yaml File Created Successfully");
    }

    public Employee getEmployee() {
        Employee employee = new Employee();
        Address address = new Address();
        employee.setId(1);
        employee.setName("John");
        employee.setLocation("Dallas");
        employee.setPhone("313-456-7785");
        address.setCity("Dallas");
        address.setState("Texas");
        address.setZipcode("45001");
        address.setCountry("USA");
        employee.setAddress(address);
        return employee;
    }
}
