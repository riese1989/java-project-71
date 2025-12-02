package hexlet.code;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

import java.io.IOException;
import java.util.Map;

public class Parser {
    public static Map parse(String content) throws IOException {
        var mapper =  content.trim().startsWith("{") ? new ObjectMapper() : new YAMLMapper();

        return mapper.readValue(content, Map.class);
    }
}
