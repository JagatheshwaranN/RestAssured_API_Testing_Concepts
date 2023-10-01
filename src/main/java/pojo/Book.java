package pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Book {

    @JsonProperty("book name")
    private String bookName;

    @JsonProperty("book author")
    private String bookAuthor;

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

}
