package hexlet.code;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

public class FileService {
    public static Map parse(String filePath) {
        var resolvedPath = resolvePath(filePath);
        var file = resolvedPath.toFile();
        var objectMapper = new ObjectMapper();

        try {
            return objectMapper.readValue(file, Map.class);
        } catch (IOException e) {
            throw new RuntimeException("Error of parsing file %s:%s".formatted(filePath, e.getMessage()));
        }
    }
    private static Path resolvePath(String filePath) {
        var baseDir = Paths.get("build", "resources", "main");
        var path = baseDir.resolve(filePath).normalize();

        if (!path.isAbsolute()) {
            path = path.toAbsolutePath();
        }

        return path;
    }
}
