package hexlet.code;

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

    public static File getFile(String filePath) throws IOException {
        var path = resolvePath(filePath);
        var content = new String(Files.readAllBytes(path));
        var extension = filePath.substring(filePath.indexOf(".") + 1);

        return new File(content, extension);
    }
}
