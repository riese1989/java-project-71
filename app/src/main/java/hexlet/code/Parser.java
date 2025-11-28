package hexlet.code;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

import java.io.IOException;
import java.util.Map;

public class Parser {
    public static Map parse(String filePath) throws IOException {
        var mapper = chooseMapper(filePath);
        var file = FileService.getFile(filePath);

        return mapper.readValue(file, Map.class);
    }

    private static ObjectMapper chooseMapper(String filePath) {
        if ("json".equals(filePath.split("\\.")[1])) {
            return new ObjectMapper();
        }

        return new YAMLMapper();
    }
}
