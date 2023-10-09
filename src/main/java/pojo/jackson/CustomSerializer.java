package pojo.jackson;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;

public class CustomSerializer extends StdSerializer<JacksonSerialize> {

    public CustomSerializer(Class<JacksonSerialize> type) {
        super(type);
    }

    public CustomSerializer() {
       this(null);
    }

    @Override
    public void serialize(JacksonSerialize value, JsonGenerator generator, SerializerProvider provider) throws IOException {

        generator.writeStartObject();
        generator.writeStringField("name", value.getName());
        generator.writeStringField("email", value.getEmail());
        generator.writeEndObject();
    }
}
