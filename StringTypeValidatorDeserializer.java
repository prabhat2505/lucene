import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;

public class StringTypeValidatorDeserializer extends JsonDeserializer<String> {

    @Override
    public String deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        // Check if the value is a string
        if (p.getCurrentToken().isBoolean() || p.getCurrentToken().isNumber()) {
            throw new IOException("Invalid type: expected a string value.");
        }
        return p.getText(); // Return the string value
    }
}


public class InvalidTypeException extends RuntimeException {
    public InvalidTypeException(String message) {
        super(message);
    }
}
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<String> handleDeserializationError(HttpMessageNotReadableException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid request: " + ex.getMessage());
    }
