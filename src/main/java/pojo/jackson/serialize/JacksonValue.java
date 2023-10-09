package pojo.jackson.serialize;

import com.fasterxml.jackson.annotation.JsonValue;

public class JacksonValue {

    private String name;

    private int id;

    private String email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @JsonValue
    public String toString(){
        return "["+this.id+" , "+ this.name+" , "+this.email+"]";
    }

}
