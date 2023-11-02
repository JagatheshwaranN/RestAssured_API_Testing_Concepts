package yaml;

import org.testng.annotations.Test;
import org.yaml.snakeyaml.Yaml;
import pojo.yaml.Candidates;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class YamlPointerTestCase {

    @Test(priority = 1)
    public void yamlPointer() {
        String filePath = System.getProperty("user.dir")+"/src/main/java/yaml/files/candidates.yaml";
        Yaml yaml = new Yaml();
        Candidates candidates;
        try {
            candidates = yaml.loadAs(new FileInputStream(filePath), Candidates.class);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        System.out.println(candidates.getCandidate1().getFirstname());
        System.out.println(candidates.getCandidate1());
        System.out.println(candidates.getCandidate2());
    }

}
