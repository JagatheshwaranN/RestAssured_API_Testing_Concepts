package json_path.jayway;

import com.jayway.jsonpath.Criteria;
import com.jayway.jsonpath.Filter;
import com.jayway.jsonpath.JsonPath;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class EvaluateJsonPathUsingFilterTestCase {

    @Test(priority = 1)
    public void evaluateJsonPathUsingFilter() throws IOException {

        try(InputStream jsonFile = new FileInputStream("src//test//resources//book_store.json")){

            Filter filterCondition = Filter
                    .filter(Criteria
                            .where("price")
                            .lt(10));
            List<Object> prices = JsonPath.parse(jsonFile).read("$.store.book[?].price", filterCondition);
            prices.forEach(System.out::println);
        }
    }

    @Test(priority = 2)
    public void evaluateJsonPathUsingFilterWithAndOption() throws IOException {

        try(InputStream jsonFile = new FileInputStream("src//test//resources//book_store.json")){

            Filter filterCondition = Filter
                    .filter(Criteria
                            .where("price")
                            .lt(10)
                            .and("category")
                            .is("fiction"));
            List<Object> books = JsonPath.parse(jsonFile).read("$.store.book[?]", filterCondition);
            books.forEach(System.out::println);
        }
    }

}
