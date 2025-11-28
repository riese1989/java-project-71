package hexlet.code.formatters;

public final class Formatter {

    public FormatterInterface getFormatter(String nameFormatter) {
        return switch (nameFormatter) {
            case "stylish" -> new Stylish();
            case "plain" -> new Plain();
            case "json" -> new Json();
            default -> throw new RuntimeException("Unexpected value: " + nameFormatter);
        };
    }
}
