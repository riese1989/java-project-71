package hexlet.code;


import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Differ {
    public static String generate(String filePath1, String filePath2) {
        var map1 = FileService.parse(filePath1);
        var map2 = FileService.parse(filePath2);
        var mergedMap = new HashMap<>(Map.copyOf(map1));
        var stringBuilder = new StringBuilder("{\n");

        mergedMap.putAll(map2);

        Map<String, Object> sortedMap = new TreeMap<>(mergedMap);

        for (Map.Entry<String, Object> entry : sortedMap.entrySet()) {
            var key = entry.getKey();
            var valueMap1 = map1.get(key);
            var valueMap2 = map2.get(key);

            if (valueMap1 == null) {
                stringBuilder.append(" + %s:%s\n".formatted(key, valueMap2));

                continue;
            }

            if (valueMap2 == null) {
                stringBuilder.append(" - %s:%s\n".formatted(key, valueMap1));

                continue;
            }

            if (valueMap1.equals(valueMap2)) {
                stringBuilder.append("   %s:%s\n".formatted(key, valueMap1));
            } else {
                stringBuilder.append(" - %s:%s\n".formatted(key, valueMap1));
                stringBuilder.append(" + %s:%s\n".formatted(key, valueMap2));
            }
        }

        stringBuilder.append("}");

        return stringBuilder.toString();
    }
}
