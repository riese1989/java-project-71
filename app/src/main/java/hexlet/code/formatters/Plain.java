package hexlet.code.formatters;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public final class Plain implements FormatterInterface {
    @Override
    public String format(List<Map<String, Object>> differences) {
        var result = new StringBuilder();

        for (var diff : differences) {
            var status = diff.get("status").toString();

            switch (status) {
                case "unchanged":
                    continue;
                case "removed": {
                    result.append("Property '%s' was removed\n".formatted(diff.get("key")));

                    break;
                }
                case "added": {
                    result.append("Property '%s' was added with value: %s\n"
                            .formatted(diff.get("key"), getValue(diff.get("newValue"))));

                    break;
                }
                case "updated": {
                    result.append("Property '%s' was updated. From %s to %s\n"
                            .formatted(diff.get("key"),
                                    getValue(diff.get("oldValue")),
                                    getValue(diff.get("newValue"))));
                    break;
                }
                default:
                    throw new RuntimeException("Unexpected status: " + status);

            }
        }

        return result.toString().trim();
    }

    private String getValue(Object data) {
        if (data == null) {
            return "null";
        }

        if (data instanceof Object[] || data instanceof Map || data instanceof Collection) {
            return "[complex value]";
        }

        if (data instanceof String) {
            return "'" + data + "'";
        }

        return data.toString();
    }
}
