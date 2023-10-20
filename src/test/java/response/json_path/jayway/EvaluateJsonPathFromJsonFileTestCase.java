package response.json_path.jayway;

import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class EvaluateJsonPathFromJsonFileTestCase {

    @Test(priority = 1)
    public void evaluateJsonPathUsingNormalApproach() throws IOException {

        try(InputStream jsonFile = new FileInputStream("src//test//resources//book_store.json")){

            List<Object> prices = JsonPath.read(jsonFile, "$..price");
            prices.forEach(System.out::println);
        }
    }

    @Test(priority = 2)
    public void evaluateJsonPathUsingConfigurationApproach() throws IOException {

        try(InputStream jsonFile = new FileInputStream("src//test//resources//book_store.json")){

            // The below line is used to parse the Json file ONLY once and read many times.
            Object parsedJsonFile = Configuration.defaultConfiguration().jsonProvider().parse(jsonFile.readAllBytes());
            List<Object> prices = JsonPath.read(parsedJsonFile, "$..price");
            prices.forEach(System.out::println);
        }
    }

    @Test(priority = 3)
    public void evaluateJsonPathUsingDocumentContextApproach() throws IOException {

        try(InputStream jsonFile = new FileInputStream("src//test//resources//book_store.json")){

            DocumentContext context = JsonPath.parse(jsonFile);
            List<Object> prices = context.read("$..price");
            prices.forEach(System.out::println);
        }
    }

    @Test(priority = 4)
    public void evaluateJsonPathUsingDocumentContextAndConfigApproach() throws IOException {

        try(InputStream jsonFile = new FileInputStream("src//test//resources//book_store.json")){

            Configuration configuration = Configuration.defaultConfiguration();
            DocumentContext context = JsonPath.using(configuration).parse(jsonFile);
            List<Object> prices = context.read("$..price");
            prices.forEach(System.out::println);
        }
    }
}