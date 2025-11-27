package hexlet.code;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class DifferTest {
    @Test
    @DisplayName("generate когда разные файлы JSON с форматированием stylish")
    void generateDifferentJsonFilesStylishTest() {
        var result = Differ.generate("file1.json", "file2.json");

        assertEquals("{\n"
                + "    chars1: [a, b, c]\n"
                + "  - chars2: [d, e, f]\n"
                + "  + chars2: false\n"
                + "  - checked: false\n"
                + "  + checked: true\n"
                + "  - default: null\n"
                + "  + default: [value1, value2]\n"
                + "  - id: 45\n"
                + "  + id: null\n"
                + "  - key1: value1\n"
                + "  + key2: value2\n"
                + "    numbers1: [1, 2, 3, 4]\n"
                + "  - numbers2: [2, 3, 4, 5]\n"
                + "  + numbers2: [22, 33, 44, 55]\n"
                + "  - numbers3: [3, 4, 5]\n"
                + "  + numbers4: [4, 5, 6]\n"
                + "  + obj1: {nestedKey=value, isNested=true}\n"
                + "  - setting1: Some value\n"
                + "  + setting1: Another value\n"
                + "  - setting2: 200\n"
                + "  + setting2: 300\n"
                + "  - setting3: true\n"
                + "  + setting3: none\n"
                + "}", result);
    }

    @Test
    @DisplayName("generate когда одинаковые файлы JSON с форматированием stylish")
    void generateEqualsJsonFilesStylishTest() {
        var result = Differ.generate("file1.json", "file1.json");

        assertEquals("{\n"
                + "    chars1: [a, b, c]\n"
                + "    chars2: [d, e, f]\n"
                + "    checked: false\n"
                + "    default: null\n"
                + "    id: 45\n"
                + "    key1: value1\n"
                + "    numbers1: [1, 2, 3, 4]\n"
                + "    numbers2: [2, 3, 4, 5]\n"
                + "    numbers3: [3, 4, 5]\n"
                + "    setting1: Some value\n"
                + "    setting2: 200\n"
                + "    setting3: true\n"
                + "}", result);
    }

    @Test
    @DisplayName("generate когда произошла ошибка при парсинге файла JSON с форматированием stylish")
    void generateExceptionJsonParsingStylishTest() {
        var ex = assertThrows(RuntimeException.class, () -> Differ.generate("file1.json", "INCORRECT FILEPATH"));

        assertTrue(ex.getMessage().contains("Неподдерживаемый формат файла"));
    }

    @Test
    @DisplayName("generate когда разные файлы YML с форматированием stylish")
    void generateDifferentYmlFilesStylishTest() {
        var result = Differ.generate("filepath1.yml", "filepath2.yml");

        assertEquals("{\n"
                + "    chars1: [a, b, c]\n"
                + "  - chars2: [d, e, f]\n"
                + "  + chars2: false\n"
                + "  - checked: false\n"
                + "  + checked: true\n"
                + "  - default: null\n"
                + "  + default: [value1, value2]\n"
                + "  - id: 45\n"
                + "  + id: null\n"
                + "  - key1: value1\n"
                + "  + key2: value2\n"
                + "    numbers1: [1, 2, 3, 4]\n"
                + "  - numbers2: [2, 3, 4, 5]\n"
                + "  + numbers2: [22, 33, 44, 55]\n"
                + "  - numbers3: [3, 4, 5]\n"
                + "  + numbers4: [4, 5, 6]\n"
                + "  + obj1: {nestedKey=value, isNested=true}\n"
                + "  - setting1: Some value\n"
                + "  + setting1: Another value\n"
                + "  - setting2: 200\n"
                + "  + setting2: 300\n"
                + "  - setting3: true\n"
                + "  + setting3: none\n"
                + "}", result);
    }

    @Test
    @DisplayName("generate когда одинаковые файлы YML с форматированием stylish")
    void generateEqualsYmlFilesStylishTest() {
        var result = Differ.generate("filepath1.yml", "filepath1.yml");

        assertEquals("{\n"
                + "    chars1: [a, b, c]\n"
                + "    chars2: [d, e, f]\n"
                + "    checked: false\n"
                + "    default: null\n"
                + "    id: 45\n"
                + "    key1: value1\n"
                + "    numbers1: [1, 2, 3, 4]\n"
                + "    numbers2: [2, 3, 4, 5]\n"
                + "    numbers3: [3, 4, 5]\n"
                + "    setting1: Some value\n"
                + "    setting2: 200\n"
                + "    setting3: true\n"
                + "}", result);
    }

    @Test
    @DisplayName("generate когда произошла ошибка при парсинге файла YML с форматированием stylish")
    void generateExceptionYmlParsingStylishTest() {
        var ex = assertThrows(RuntimeException.class, () -> Differ.generate("filepath1.yml", "INCORRECT FILEPATH"));

        assertTrue(ex.getMessage().contains("Неподдерживаемый формат файла"));
    }

    @Test
    @DisplayName("generate когда разные файлы JSON с форматированием plain")
    void generateDifferentJsonFilesPlainTest() {
        var result = Differ.generate("file1.json", "file2.json", "plain");

        assertEquals("{\n"
                + "Property 'chars2' was updated. From [complex value] to false\n"
                + "Property 'checked' was updated. From false to true\n"
                + "Property 'default' was updated. From null to [complex value]\n"
                + "Property 'id' was updated. From 45 to null\n"
                + "Property 'key1' was removed\n"
                + "Property 'key2' was added with value: value2\n"
                + "Property 'numbers2' was updated. From [complex value] to [complex value]\n"
                + "Property 'numbers3' was removed\n"
                + "Property 'numbers4' was added with value: [complex value]\n"
                + "Property 'obj1' was added with value: [complex value]\n"
                + "Property 'setting1' was updated. From Some value to Another value\n"
                + "Property 'setting2' was updated. From 200 to 300\n"
                + "Property 'setting3' was updated. From true to none\n"
                + "}", result);
    }

    @Test
    @DisplayName("generate когда одинаковые файлы JSON с форматированием plain")
    void generateEqualsJsonFilesPlainTest() {
        var result = Differ.generate("file1.json", "file1.json", "plain");

        assertEquals("{\n"
                + "}", result);
    }

    @Test
    @DisplayName("generate когда произошла ошибка при парсинге файла JSON с форматированием plain")
    void generateExceptionJsonParsingPlainTest() {
        var ex = assertThrows(RuntimeException.class,
                () -> Differ.generate("file1.json", "INCORRECT FILEPATH", "plain"));

        assertTrue(ex.getMessage().contains("Неподдерживаемый формат файла"));
    }

    @Test
    @DisplayName("generate когда разные файлы YML с форматированием plain")
    void generateDifferentYmlFilesPlainTest() {
        var result = Differ.generate("filepath1.yml", "filepath2.yml", "plain");

        assertEquals("{\n"
                + "Property 'chars2' was updated. From [complex value] to false\n"
                + "Property 'checked' was updated. From false to true\n"
                + "Property 'default' was updated. From null to [complex value]\n"
                + "Property 'id' was updated. From 45 to null\n"
                + "Property 'key1' was removed\n"
                + "Property 'key2' was added with value: value2\n"
                + "Property 'numbers2' was updated. From [complex value] to [complex value]\n"
                + "Property 'numbers3' was removed\n"
                + "Property 'numbers4' was added with value: [complex value]\n"
                + "Property 'obj1' was added with value: [complex value]\n"
                + "Property 'setting1' was updated. From Some value to Another value\n"
                + "Property 'setting2' was updated. From 200 to 300\n"
                + "Property 'setting3' was updated. From true to none\n"
                + "}", result);
    }

    @Test
    @DisplayName("generate когда одинаковые файлы YML с форматированием plain")
    void generateEqualsYmlFilesPlainTest() {
        var result = Differ.generate("filepath1.yml", "filepath1.yml", "plain");

        assertEquals("{\n"
                + "}", result);
    }

    @Test
    @DisplayName("generate когда произошла ошибка при парсинге файла YML с форматированием plain")
    void generateExceptionYmlParsingPlainTest() {
        var ex = assertThrows(RuntimeException.class,
                () -> Differ.generate("filepath1.yml", "INCORRECT FILEPATH", "plain"));

        assertTrue(ex.getMessage().contains("Неподдерживаемый формат файла"));
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
    @DisplayName("generate когда произошла ошибка при парсинге файла JSON с форматированием json")
    void generateExceptionJsonParsingJsonTest() {
        var ex = assertThrows(RuntimeException.class,
                () -> Differ.generate("file1.json", "INCORRECT FILEPATH", "json"));

        assertTrue(ex.getMessage().contains("Неподдерживаемый формат файла"));
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

    @Test
    @DisplayName("generate когда произошла ошибка при парсинге файла YML с форматированием json")
    void generateExceptionYmlParsingJsonTest() {
        var ex = assertThrows(RuntimeException.class,
                () -> Differ.generate("filepath1.yml", "INCORRECT FILEPATH", "json"));

        assertTrue(ex.getMessage().contains("Неподдерживаемый формат файла"));
    }
}
