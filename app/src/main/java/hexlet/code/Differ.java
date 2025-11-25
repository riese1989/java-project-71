package hexlet.code;


import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Differ {
    public static String generate(String filePath1, String filePath2) {
        var map1 = Parser.parse(filePath1);
        var map2 = Parser.parse(filePath2);
        var mergedMap = new HashMap<>(Map.copyOf(map1));
        var stringBuilder = new StringBuilder("{");

        mergedMap.putAll(map2);

        Map<String, Object> sortedMap = new TreeMap<>(mergedMap);

        for (Map.Entry<String, Object> entry : sortedMap.entrySet()) {
            var key = entry.getKey();
            var valueMap1 = map1.get(key);
            var valueMap2 = map2.get(key);

            if (valueMap1 == null) {
                stringBuilder.append("\n + %s:%s".formatted(key, valueMap2));

                continue;
            }

            if (valueMap2 == null) {
                stringBuilder.append("\n - %s:%s".formatted(key, valueMap1));

                continue;
            }

            if (valueMap1.equals(valueMap2)) {
                stringBuilder.append("\n   %s:%s".formatted(key, valueMap1));
            } else {
                stringBuilder.append("\n - %s:%s".formatted(key, valueMap1));
                stringBuilder.append("\n + %s:%s".formatted(key, valueMap2));
            }
        }

        stringBuilder.append("\n}");

        return stringBuilder.toString();
    }
}
