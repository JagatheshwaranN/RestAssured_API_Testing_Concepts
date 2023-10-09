package pojo.jackson.serialize;

import com.fasterxml.jackson.annotation.JsonAnyGetter;

import java.util.Map;

public class JacksonAnyGetter {

    Map<String, Object> employee;

    @JsonAnyGetter
    public Map<String, Object> getEmployee() {
        return employee;
    }

    public void setEmployee(Map<String, Object> employee) {
        this.employee = employee;
    }
}
