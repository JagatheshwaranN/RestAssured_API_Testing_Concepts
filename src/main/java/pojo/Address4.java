package pojo;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Address4 {

    private String city;

    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    private int zipcode;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> landmark;

    private String state;

    private String country;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getZipcode() {
        return zipcode;
    }

    public void setZipcode(int zipcode) {
        this.zipcode = zipcode;
    }

    public List<String> getLandmark() {
        return landmark;
    }

    public void setLandmark(List<String> landmark) {
        this.landmark = landmark;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

}
