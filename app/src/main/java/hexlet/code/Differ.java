package hexlet.code;


import hexlet.code.formatters.Formatter;

import java.io.IOException;

import static hexlet.code.DifferenceService.differ;

public class Differ {

    public static String generate(String filePath1, String filePath2) throws IOException {
        return generate(filePath1, filePath2, "stylish");
    }

    public static String generate(String filePath1, String filePath2, String format) throws IOException {
        var file1 = FileService.getFile(filePath1);
        var file2 = FileService.getFile(filePath2);
        var map1 = Parser.parse(file1.content(), file1.extension());
        var map2 = Parser.parse(file2.content(), file2.extension());

        var formatter = new Formatter().getFormatter(format);

        var difference = differ(map1, map2);

        return formatter.format(difference);
    }

}
