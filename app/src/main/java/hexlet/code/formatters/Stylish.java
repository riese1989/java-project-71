package hexlet.code.formatters;

import java.util.List;
import java.util.Map;

public final class Stylish implements FormatterInterface {

    @Override
    public String format(List<Map<String, Object>> differences) {
        var result = new StringBuilder("{\n");

        for (var diffs : differences) {
            var status = diffs.get("status").toString();

            switch (status) {
                case "removed": {
                    result.append("  - ").append(diffs.get("key")).append(": ")
                            .append(diffs.get("oldValue")).append("\n");

                    break;
                }
                case "added": {
                    result.append("  + ").append(diffs.get("key")).append(": ")
                            .append(diffs.get("newValue")).append("\n");

                    break;
                }
                case "unchanged": {
                    result.append("    ").append(diffs.get("key")).append(": ")
                            .append(diffs.get("oldValue")).append("\n");

                    break;
                }
                case "updated": {
                    result.append("  - ").append(diffs.get("key")).append(": ")
                            .append(diffs.get("oldValue")).append("\n");
                    result.append("  + ").append(diffs.get("key")).append(": ")
                            .append(diffs.get("newValue")).append("\n");

                    break;
                }
                default: throw new RuntimeException("Unexpected status: " + status);
            }
        }

        result.append("}");

        return result.toString();
    }
}
