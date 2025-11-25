package hexlet.code;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

public class Parser {
    public static Map parse(String filePath) {
        var resolvedPath = resolvePath(filePath);
        var file = resolvedPath.toFile();
        var extension = getFileExtension(filePath);

        try {
            return switch (extension) {
                case "json" -> new ObjectMapper().readValue(file, Map.class);
                case "yaml", "yml" -> new YAMLMapper().readValue(file, Map.class);
                default -> throw new IllegalStateException("Неподдерживаемый формат файла: " + extension);
            };
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

    private static String getFileExtension(String filePath) {
        var dotPosition = filePath.lastIndexOf('.');

        if (dotPosition > 0 && dotPosition < filePath.length() - 1) {
            return filePath.substring(dotPosition + 1);
        }

        return "";
    }
}
