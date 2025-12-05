package hexlet.code;

import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

import java.io.IOException;
import java.util.Map;

public class Parser {
    public static Map parse(File file) throws IOException {
        var mapper = switch (file.extension()) {
            case "yaml", "yml" -> new YAMLMapper();
            case "json" -> new JsonMapper();
            default -> throw new IllegalStateException("Unexpected value: " + file.extension());
        };

        return mapper.readValue(file.content(), Map.class);
    }
}
