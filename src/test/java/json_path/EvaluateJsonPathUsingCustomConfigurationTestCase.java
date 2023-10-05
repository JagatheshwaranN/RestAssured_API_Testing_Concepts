package json_path;

import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.Option;
import org.testng.annotations.Test;

public class EvaluateJsonPathUsingCustomConfigurationTestCase {

    @Test(priority = 1)
    public void evaluateJsonPathUsingCustomConfigurationApproach1() {

        String sampleJson = """
                [
                  {
                    "name": "John",
                    "mobile": 1234567890
                  },
                  {
                    "name": "Alex"
                  }
                ]""";
        Configuration configuration = Configuration.defaultConfiguration();
        configuration.addOptions(Option.DEFAULT_PATH_LEAF_TO_NULL);

        int mobileNumber = JsonPath.using(configuration).parse(sampleJson).read("$.[0].mobile");
        System.out.println(mobileNumber);
    }

    @Test(priority = 2)
    public void evaluateJsonPathUsingCustomConfigurationApproach2() {

        String sampleJson = """
                [
                  {
                    "name": "John",
                    "mobile": 1234567890
                  },
                  {
                    "name": "Alex"
                  }
                ]""";

        Configuration configuration =
                Configuration
                .builder()
                .options(Option.DEFAULT_PATH_LEAF_TO_NULL)
                .build();

        var mobileNumber = JsonPath.using(configuration).parse(sampleJson).read("$.[1].mobile");
        System.out.println(mobileNumber);
    }

}
