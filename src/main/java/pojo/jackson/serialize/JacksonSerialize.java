package pojo.jackson.serialize;


import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.util.List;

@JsonSerialize(using = CustomSerializer.class)
public class JacksonSerialize {


    private String name;

    private String email;

    private List<String> skills;

    private Devices devices;

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

    public List<String> getSkills() {
        return skills;
    }

    public void setSkills(List<String> skills) {
        this.skills = skills;
    }

    public Devices getDevices() {
        return devices;
    }

    public void setDevices(Devices devices) {
        this.devices = devices;
    }

}
