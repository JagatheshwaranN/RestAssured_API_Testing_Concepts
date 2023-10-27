package pojo.jackson.deserialize.json;

import com.fasterxml.jackson.annotation.JsonAnySetter;

import java.util.HashMap;
import java.util.Map;

public class JacksonAnySetter {

    private final Map<String, Object> employee = new HashMap<>();

    public Map<String, Object> getEmployee() {
        return employee;
    }

    @JsonAnySetter
    public void setEmployee(String key, Object value) {
        employee.put(key, value);
    }
}
