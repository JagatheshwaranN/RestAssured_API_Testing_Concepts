package json_path;

import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.JsonPath;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class EvaluateJsonPathFromJsonFileTestCase {

    @Test(priority = 1)
    public void evaluateJsonPathFromJson() throws IOException {

        try(InputStream jsonFile = new FileInputStream("src//test//resources//book_store.json")){

            // The below line is used to parse the Json file ONLY once and read many times.
            Object parsedJsonFile = Configuration.defaultConfiguration().jsonProvider().parse(jsonFile.readAllBytes());
            List<Object> prices = JsonPath.read(parsedJsonFile, "$..price");
            prices.forEach(System.out::println);
        }
    }
}