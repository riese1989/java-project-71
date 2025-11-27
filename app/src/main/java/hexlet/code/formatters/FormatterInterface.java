package hexlet.code.formatters;

import java.util.List;
import java.util.Map;

@FunctionalInterface
public interface FormatterInterface {
    String format(List<Map<String, Object>> differences);
}
