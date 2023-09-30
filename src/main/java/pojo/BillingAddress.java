package pojo;

import com.fasterxml.jackson.annotation.JsonIncludeProperties;

import java.util.List;

@JsonIncludeProperties(value = {"city", "state", "landmark", "country"})
public class BillingAddress  extends Address5 {

    private List<String> landmark;

    public List<String> getLandmark() {
        return landmark;
    }

    public void setLandmark(List<String> landmark) {
        this.landmark = landmark;
    }

}
