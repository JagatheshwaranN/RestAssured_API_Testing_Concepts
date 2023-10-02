package schema_validation.networknt;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.networknt.schema.JsonSchema;
import com.networknt.schema.JsonSchemaFactory;
import com.networknt.schema.SpecVersion;
import com.networknt.schema.ValidationMessage;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Set;

/**
 * @restapi
 * @get
 */
public class JsonSchemaValidationTestCase {

    @Test(priority = 1)
    public void validateJsonSchema() throws IOException {

        ObjectMapper objectMapper = new ObjectMapper();
        JsonSchemaFactory jsonSchemaFactory = JsonSchemaFactory.getInstance(SpecVersion.VersionFlag.V4);
        File inputJson = new File("src//test//resources//student_schema.json");
        InputStream inputSchema = new FileInputStream("src//test//resources//json_schema.json");
        JsonNode jsonNode = objectMapper.readTree(inputJson);
        JsonSchema jsonSchema = jsonSchemaFactory.getSchema(inputSchema);
        Set<ValidationMessage> result = jsonSchema.validate(jsonNode);
        if(result.isEmpty())
            System.out.println("Json Schema validation is Successful without Errors");
        else
            for(ValidationMessage message : result){
                System.out.println(message);
            }
    }

}
