package pojo.jackson.serialize;

import com.fasterxml.jackson.annotation.JsonGetter;

public class JacksonGetter {

    private int id;

    private String name;

    private String email;

    @JsonGetter(value = "empId")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
