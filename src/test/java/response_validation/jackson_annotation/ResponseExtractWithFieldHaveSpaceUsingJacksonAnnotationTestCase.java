package response_validation.jackson_annotation;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.annotations.Test;
import pojo.Book;

/**
 * @restapi
 * @get
 */
public class ResponseExtractWithFieldHaveSpaceUsingJacksonAnnotationTestCase {

    @Test
    public void responseExtractWithFieldHaveSpaceUsingJacksonAnnotation() throws JsonProcessingException {

       String bookJson = """
               {
                 "book name" : "Java The Complete Reference",
                 "book author" : "Herbert Schildt"
               }
               """;

        ObjectMapper objectMapper = new ObjectMapper();
        Book book = objectMapper.readValue(bookJson, Book.class);
        System.out.println(book.getBookName());
        System.out.println(book.getBookAuthor());
    }

}
