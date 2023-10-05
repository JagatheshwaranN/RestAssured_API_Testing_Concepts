package json_path;

import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.Predicate;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

public class EvaluateJsonPathUsingCustomPredicateTestCase {

    @Test(priority = 1)
    public void evaluateJsonPathUsingCustomPredicate() throws IOException {

        Predicate booksWithISBN = new Predicate() {
            @Override
            public boolean apply(PredicateContext predicateContext) {
                return predicateContext.item(Map.class).containsKey("isbn");
            }
        };

        try(InputStream jsonFile = new FileInputStream("src//test//resources//book_store.json")){

            List<Map<String, Object>> books = JsonPath.parse(jsonFile).read("$.store.book[?]", booksWithISBN);
            books.forEach(System.out::println);
        }
    }

    @Test(priority = 2)
    public void evaluateJsonPathUsingCustomPredicateInLambdaForm() throws IOException {

        Predicate booksWithISBN = predicateContext -> predicateContext.item(Map.class).containsKey("isbn");

        try(InputStream jsonFile = new FileInputStream("src//test//resources//book_store.json")){

            List<Map<String, Object>> books = JsonPath.parse(jsonFile).read("$.store.book[?]", booksWithISBN);
            books.forEach(System.out::println);
        }
    }
}
