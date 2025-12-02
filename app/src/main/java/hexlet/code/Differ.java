package hexlet.code;


import hexlet.code.formatters.Formatter;

import java.io.IOException;

import static hexlet.code.DifferenceService.differ;

public class Differ {

    public static String generate(String filePath1, String filePath2) throws IOException {
        return generate(filePath1, filePath2, "stylish");
    }

    public static String generate(String filePath1, String filePath2, String format) throws IOException {
        var contentFile1 = FileService.getContent(filePath1);
        var contentFile2 = FileService.getContent(filePath2);
        var map1 = Parser.parse(contentFile1);
        var map2 = Parser.parse(contentFile2);

        var formatter = new Formatter().getFormatter(format);

        var difference = differ(map1, map2);

        return formatter.format(difference);
    }

}
