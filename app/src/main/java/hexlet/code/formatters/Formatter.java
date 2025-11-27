package hexlet.code.formatters;

import java.util.Map;

import static java.util.Optional.ofNullable;

public class Formatter {

    public FormatterInterface getFormatter(String nameFormatter) {
        var formaterMap = Map.of("stylish", new Stylish(), "plain", new Plain(), "json", new Json());
        var formatter = formaterMap.get(nameFormatter);

        return ofNullable(formatter).orElseThrow(() -> new IllegalArgumentException("Неизвестный вид форматтера"));
    }
}
