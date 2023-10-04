package json_path;

import com.jayway.jsonpath.JsonPath;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class EvaluateJsonPathFromJsonFileTestCase {

    @Test(priority = 1)
    public void evaluateJsonPathFromJson() throws IOException {

        File jsonFile = new File("src//test//resources//book_store.json");
        List<Object> prices = JsonPath.read(jsonFile, "$..price");
        prices.forEach(System.out::println);
    }
}
