package response.json_path.jayway;

import com.jayway.jsonpath.Filter;
import com.jayway.jsonpath.JsonPath;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

import static com.jayway.jsonpath.Criteria.where;
import static com.jayway.jsonpath.Filter.filter;

public class EvaluateJsonPathUsingFilterWithStaticImportTestCase {

    @Test(priority = 1)
    public void evaluateJsonPathUsingFilterWithStaticImport() throws IOException {

        try(InputStream jsonFile = new FileInputStream("src//test//resources//book_store.json")){

                   Filter filterCondition = filter(
                            where("price")
                            .lt(10)
                            .and("category")
                            .is("fiction"));
            List<Map<String, Object>> books = JsonPath.parse(jsonFile).read("$.store.book[?]", filterCondition);
            books.forEach(System.out::println);
        }
    }
    
}
