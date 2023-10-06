package pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

/*
    We can also use @Data annotation to generate the Getters and Setters along with additional
    methods.
*/
@Getter
@Setter
public class Book {

    @JsonProperty("book name")
    private String bookName;

    @JsonProperty("book author")
    private String bookAuthor;

}
