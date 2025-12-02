package hexlet.code.formatters;

import java.util.List;
import java.util.Map;

public final class Stylish implements FormatterInterface {

    @Override
    public String format(List<Map<String, Object>> differences) {
        var result = new StringBuilder("{\n");

        for (var diffs : differences) {
            var status = diffs.get("status").toString();

            if ("removed".equals(status)) {
                result.append("  - ").append(diffs.get("key")).append(": ")
                        .append(diffs.get("oldValue")).append("\n");
            }

            if ("added".equals(status)) {
                result.append("  + ").append(diffs.get("key")).append(": ")
                        .append(diffs.get("newValue")).append("\n");
            }

            if ("unchanged".equals(status)) {
                result.append("    ").append(diffs.get("key")).append(": ")
                        .append(diffs.get("oldValue")).append("\n");
            }

            if ("updated".equals(status)) {
                result.append("  - ").append(diffs.get("key")).append(": ")
                        .append(diffs.get("oldValue")).append("\n");
                result.append("  + ").append(diffs.get("key")).append(": ")
                        .append(diffs.get("newValue")).append("\n");
            }
        }

        result.append("}");

        return result.toString();
    }
}
