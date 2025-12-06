package hexlet.code;

import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

import java.io.IOException;
import java.util.Map;

public class Parser {
    public static Map parse(String content, String formatData) throws IOException {
        var mapper = switch (formatData) {
            case "yaml", "yml" -> new YAMLMapper();
            case "json" -> new JsonMapper();
            default -> throw new IllegalStateException("Unexpected value: " + formatData);
        };

        return mapper.readValue(content, Map.class);
    }
}
