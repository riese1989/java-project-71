package hexlet.code;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileService {
    public static File getFile(String filePath) {
        var resolvedPath = resolvePath(filePath);

        return resolvedPath.toFile();
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
