package hexlet.code;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DifferTest {
    @Test
    @DisplayName("generate когда разные файлы JSON с форматированием default")
    void generateDifferentJsonFilesDefaultTest() throws IOException {
        var result = Differ.generate("file1.json", "file2.json");
        var expDiff = new String(Files.readAllBytes(Paths.get("src/test/resources/expRes1")));

        assertEquals(expDiff, result);
    }

    @Test
    @DisplayName("generate когда одинаковые файлы JSON с форматированием default")
    void generateEqualsJsonFilesDefaultTest() throws IOException {
        var result = Differ.generate("file1.json", "file1.json");
        var expDiff = new String(Files.readAllBytes(Paths.get("src/test/resources/expRes2")));

        assertEquals(expDiff, result);
    }

    @Test
    @DisplayName("generate когда разные файлы YML с форматированием default")
    void generateDifferentYmlFilesDefaultTest() throws IOException {
        var result = Differ.generate("filepath1.yml", "filepath2.yml");
        var expDiff = new String(Files.readAllBytes(Paths.get("src/test/resources/expRes3")));

        assertEquals(expDiff, result);
    }

    @Test
    @DisplayName("generate когда одинаковые файлы YML с форматированием default")
    void generateEqualsYmlFilesDefaultTest() throws IOException {
        var result = Differ.generate("filepath1.yml", "filepath1.yml");
        var expDiff = new String(Files.readAllBytes(Paths.get("src/test/resources/expRes4")));

        assertEquals(expDiff, result);
    }

    @Test
    @DisplayName("generate когда разные файлы JSON с форматированием stylish")
    void generateDifferentJsonFilesStylishTest() throws IOException {
        var result = Differ.generate("file1.json", "file2.json", "stylish");
        var expDiff = new String(Files.readAllBytes(Paths.get("src/test/resources/expRes1")));

        assertEquals(expDiff, result);
    }

    @Test
    @DisplayName("generate когда одинаковые файлы JSON с форматированием stylish")
    void generateEqualsJsonFilesStylishTest() throws IOException {
        var result = Differ.generate("file1.json", "file1.json", "stylish");
        var expDiff = new String(Files.readAllBytes(Paths.get("src/test/resources/expRes2")));

        assertEquals(expDiff, result);
    }

    @Test
    @DisplayName("generate когда разные файлы YML с форматированием stylish")
    void generateDifferentYmlFilesStylishTest() throws IOException {
        var result = Differ.generate("filepath1.yml", "filepath2.yml", "stylish");
        var expDiff = new String(Files.readAllBytes(Paths.get("src/test/resources/expRes3")));

        assertEquals(expDiff, result);
    }

    @Test
    @DisplayName("generate когда одинаковые файлы YML с форматированием stylish")
    void generateEqualsYmlFilesStylishTest() throws IOException {
        var result = Differ.generate("filepath1.yml", "filepath1.yml", "stylish");
        var expDiff = new String(Files.readAllBytes(Paths.get("src/test/resources/expRes4")));

        assertEquals(expDiff, result);
    }

    @Test
    @DisplayName("generate когда разные файлы JSON с форматированием plain")
    void generateDifferentJsonFilesPlainTest() throws IOException {
        var result = Differ.generate("file1.json", "file2.json", "plain");
        var expDiff = new String(Files.readAllBytes(Paths.get("src/test/resources/expRes5")));

        assertEquals(expDiff, result);
    }

    @Test
    @DisplayName("generate когда одинаковые файлы JSON с форматированием plain")
    void generateEqualsJsonFilesPlainTest() throws IOException {
        var result = Differ.generate("file1.json", "file1.json", "plain");

        assertEquals("", result);
    }

    @Test
    @DisplayName("generate когда разные файлы YML с форматированием plain")
    void generateDifferentYmlFilesPlainTest() throws IOException {
        var result = Differ.generate("filepath1.yml", "filepath2.yml", "plain");
        var expDiff = new String(Files.readAllBytes(Paths.get("src/test/resources/expRes6")));

        assertEquals(expDiff, result);
    }

    @Test
    @DisplayName("generate когда одинаковые файлы YML с форматированием plain")
    void generateEqualsYmlFilesPlainTest() throws IOException {
        var result = Differ.generate("filepath1.yml", "filepath1.yml", "plain");

        assertEquals("", result);
    }

    @Test
    @DisplayName("generate когда разные файлы JSON с форматированием json")
    void generateDifferentJsonFilesJsonTest() throws IOException {
        var pathJson = Paths.get("src/test/resources/expJson1.json");
        var result = Differ.generate("file1.json", "file2.json", "json");

        assertEquals(Files.readString(pathJson), result);
    }

    @Test
    @DisplayName("generate когда одинаковые файлы JSON с форматированием json")
    void generateEqualsJsonFilesJsonTest() throws IOException {
        var pathJson = Paths.get("src/test/resources/expJson2.json");
        var result = Differ.generate("file1.json", "file1.json", "json");

        assertEquals(Files.readString(pathJson), result);
    }

    @Test
    @DisplayName("generate когда разные файлы YML с форматированием json")
    void generateDifferentYmlFilesJsonTest() throws IOException {
        var pathJson = Paths.get("src/test/resources/expJson3.json");
        var result = Differ.generate("filepath1.yml", "filepath2.yml", "json");

        assertEquals(Files.readString(pathJson), result);
    }

    @Test
    @DisplayName("generate когда одинаковые файлы YML с форматированием json")
    void generateEqualsYmlFilesJsonTest() throws IOException {
        var pathJson = Paths.get("src/test/resources/expJson4.json");
        var result = Differ.generate("filepath1.yml", "filepath1.yml", "json");

        assertEquals(Files.readString(pathJson), result);
    }
}
