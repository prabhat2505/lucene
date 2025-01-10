import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class RequestClassValidatorDeserializer<T> extends JsonDeserializer<T> {

    private final Class<T> targetClass;

    public RequestClassValidatorDeserializer(Class<T> targetClass) {
        this.targetClass = targetClass;
    }

    @Override
    public T deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        JsonNode node = p.readValueAsTree();

        // Ensure the incoming JSON is an object
        if (!node.isObject()) {
            ctxt.reportInputMismatch(targetClass, 
                "Invalid JSON input: Expected a JSON object but found " + node.getNodeType());
        }

        // Deserialize into the target class
        ObjectMapper mapper = (ObjectMapper) p.getCodec();
        T obj = mapper.treeToValue(node, targetClass);

        // Perform additional validations if required
        if (obj == null) {
            ctxt.reportInputMismatch(targetClass, 
                "Request body cannot be null or invalid for target type " + targetClass.getSimpleName());
        }

        return obj;
    }
}
