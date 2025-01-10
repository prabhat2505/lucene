import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class GenericObjectValidatorDeserializer<T> extends JsonDeserializer<T> {

    private final Class<T> targetClass;

    // Constructor to set the target class dynamically
    public GenericObjectValidatorDeserializer(Class<T> targetClass) {
        this.targetClass = targetClass;
    }

    @Override
    public T deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        // Parse the JSON node
        JsonNode node = p.readValueAsTree();

        // Validate that the node is a JSON object
        if (!node.isObject()) {
            ctxt.reportInputMismatch(targetClass, 
                "Expected a JSON object but found: " + node.getNodeType());
        }

        // Use ObjectMapper to deserialize the node into the target class
        ObjectMapper mapper = (ObjectMapper) p.getCodec();
        return mapper.treeToValue(node, targetClass);
    }
}
