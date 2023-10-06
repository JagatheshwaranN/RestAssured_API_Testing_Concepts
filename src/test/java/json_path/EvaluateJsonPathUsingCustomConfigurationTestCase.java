package json_path;

import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.Option;
import org.testng.annotations.Test;

import java.util.List;

public class EvaluateJsonPathUsingCustomConfigurationTestCase {

    public String sampleJson = """
                [
                  {
                    "name": "John",
                    "mobile": 1234567890
                  },
                  {
                    "name": "Alex"
                  }
                ]""";

    @Test(priority = 1)
    public void evaluateJsonPathUsingCustomConfigurationApproach1() {

        Configuration configuration = Configuration.defaultConfiguration();
        configuration.addOptions(Option.DEFAULT_PATH_LEAF_TO_NULL);

        int mobileNumber = JsonPath.using(configuration).parse(sampleJson).read("$.[0].mobile");
        System.out.println(mobileNumber);
    }

    @Test(priority = 2)
    public void evaluateJsonPathUsingCustomConfigurationApproach2() {

        Configuration configuration =
                Configuration
                .builder()
                .options(Option.DEFAULT_PATH_LEAF_TO_NULL)
                .build();

        var mobileNumber = JsonPath.using(configuration).parse(sampleJson).read("$.[1].mobile");
        System.out.println(mobileNumber);
    }

    @Test(priority = 3)
    public void evaluateJsonPathUsingCustomConfigToSaveResultAsList() {

        Configuration configuration =
                Configuration
                        .builder()
                        .options(Option.ALWAYS_RETURN_LIST)
                        .build();

        String name = JsonPath.using(configuration).parse(sampleJson).read("$.[0].name");
        System.out.println(name);
    }

    @Test(priority = 4)
    public void evaluateJsonPathUsingCustomConfigWithRequirePropertiesOption() {

        Configuration configuration =
                Configuration
                        .builder()
                        .options(Option.ALWAYS_RETURN_LIST)
                        .options(Option.REQUIRE_PROPERTIES)
                        .build();

        List<Integer> mobileNums = JsonPath.using(configuration).parse(sampleJson).read("$.[*].mobile");
        System.out.println(mobileNums);
    }

    @Test(priority = 5)
    public void evaluateJsonPathUsingCustomConfigWithReqPropAndSuppressWarnOption() {

        Configuration configuration =
                Configuration
                        .builder()
                        .options(Option.ALWAYS_RETURN_LIST)
                        .options(Option.REQUIRE_PROPERTIES)
                        .options(Option.SUPPRESS_EXCEPTIONS)
                        .build();

        List<Integer> mobileNums = JsonPath.using(configuration).parse(sampleJson).read("$.[*].mobile");
        System.out.println(mobileNums);
    }
}
