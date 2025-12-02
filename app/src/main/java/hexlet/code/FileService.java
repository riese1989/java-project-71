package hexlet.code;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileService {
    private static Path resolvePath(String filePath) {
        var baseDir = Paths.get("build", "resources", "main");
        var path = baseDir.resolve(filePath).normalize();

        if (!path.isAbsolute()) {
            path = path.toAbsolutePath();
        }

        return path;
    }

    public static String getContent(String filePath) throws IOException {
        var path = resolvePath(filePath);

        return new String(Files.readAllBytes(path));
    }
}
