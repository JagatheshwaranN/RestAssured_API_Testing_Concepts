package scenarios;

import org.skyscreamer.jsonassert.Customization;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.skyscreamer.jsonassert.comparator.CustomComparator;
import org.testng.annotations.Test;

public class CompareTwoJsonUsingJSONAssertTestCase {

    @Test(priority = 1)
    public void compareTwoJsonUsingJSONAssert() {

        String firstJson = """
                {
                   "empId" : 1,
                   "name" : "Ken",
                   "email" : "ken@test.com"
                 }""";

        String secondJson = """
                {
                   "empId" : 1,
                   "name" : "Ken",
                   "email" : {
                    "id": "ken@test.com"
                   }
                 }""";

        String thirdJson = """
                {
                   "name" : "Ken",
                   "email" : {
                    "id": "ken@test.com"
                   },
                   "empId" : 1
                 }""";


        /*
                Function without Lambda
                =======================
                JSONAssert.assertEquals(firstJson, secondJson, new CustomComparator(JSONCompareMode.STRICT,
                new Customization("email", new ValueMatcher<Object>() {
                    @Override
                    public boolean equal(Object o1, Object o2) {
                        return true;
                    }
                })));
         */

        JSONAssert.assertEquals(firstJson, secondJson, new CustomComparator(JSONCompareMode.STRICT,
                new Customization("email", (o1, o2) -> true)));

        JSONAssert.assertEquals(firstJson, thirdJson, new CustomComparator(JSONCompareMode.LENIENT,
                new Customization("email", (o1, o2) -> true)));

        JSONAssert.assertEquals(firstJson, thirdJson, new CustomComparator(JSONCompareMode.STRICT_ORDER));
    }

}
