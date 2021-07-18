package utils;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ToCypher {
    public static String adjacencyMapToCreateStatement( int numberOfNodes, Map<Integer, List<Integer>> graph, String nodeType, String relationType ) {
        var result = new StringBuilder("CREATE\n");
        result.append(
                IntStream.range(0, numberOfNodes)
                        .mapToObj(intKey -> String.format("  (n%d:%s {num:%d})", intKey, nodeType, intKey))
                        .collect(Collectors.joining(",\n"))
        );
        result.append(",\n\n");
        result.append(
                graph.keySet().stream().sorted()
                        .flatMap(intKey -> graph.get(intKey).stream().sorted().map(intValue -> new int[]{intKey, intValue}))
                        .map(keyAndValue -> String.format("  (n%d) -[:%s]-> (n%d)", keyAndValue[0], relationType, keyAndValue[1]))
                        .collect(Collectors.joining(",\n"))
        );
        result.append("\n");
        result.append("return ");
        result.append(IntStream.range(0, numberOfNodes).mapToObj(intKey -> String.format("n%d", intKey)).collect(Collectors.joining(", ")));
        result.append(";\n");
        return result.toString();
    }
}
