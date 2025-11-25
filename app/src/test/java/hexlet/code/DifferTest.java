package hexlet.code;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DifferTest {
    @Test
    @DisplayName("generate когда разные файлы JSON")
    void generateTestDifferentJsonFiles() {
        var result = Differ.generate("filepath1.yml", "filepath2.yml");

        assertEquals("{\n" +
                " - follow:false\n" +
                "   host:hexlet.io\n" +
                " - proxy:123.234.53.22\n" +
                " - timeout:50\n" +
                " + timeout:20\n" +
                " + verbose:true\n" +
                "}", result);
    }

    @Test
    @DisplayName("generate когда одинаковые файлы JSON")
    void generateTestEqualsJsonFiles() {
        var result = Differ.generate("file1.json", "file1.json");

        assertEquals("{\n" +
                "   follow:false\n" +
                "   host:hexlet.io\n" +
                "   proxy:123.234.53.22\n" +
                "   timeout:50\n" +
                "}", result);
    }

    @Test
    @DisplayName("generate когда произошла ошибка при парсинге файла JSON")
    void generateTestExceptionJsonParsing() {
        var ex =  assertThrows(RuntimeException.class, () -> Differ.generate("file1.json", "INCORRECT FILEPATH"));

        assertTrue(ex.getMessage().contains("Неподдерживаемый формат файла"));
    }

    @Test
    @DisplayName("generate когда разные файлы YML")
    void generateTestDifferentYmlFiles() {
        var result = Differ.generate("filepath1.yml", "filepath2.yml");

        assertEquals("{\n" +
                " - follow:false\n" +
                "   host:hexlet.io\n" +
                " - proxy:123.234.53.22\n" +
                " - timeout:50\n" +
                " + timeout:20\n" +
                " + verbose:true\n" +
                "}", result);
    }

    @Test
    @DisplayName("generate когда одинаковые файлы YML")
    void generateTestEqualsYmlFiles() {
        var result = Differ.generate("filepath1.yml", "filepath1.yml");

        assertEquals("{\n" +
                "   follow:false\n" +
                "   host:hexlet.io\n" +
                "   proxy:123.234.53.22\n" +
                "   timeout:50\n" +
                "}", result);
    }

    @Test
    @DisplayName("generate когда произошла ошибка при парсинге файла YML")
    void generateTestExceptionYmlParsing() {
        var ex =  assertThrows(RuntimeException.class, () -> Differ.generate("filepath1.yml", "INCORRECT FILEPATH"));

        assertTrue(ex.getMessage().contains("Неподдерживаемый формат файла"));
    }

}