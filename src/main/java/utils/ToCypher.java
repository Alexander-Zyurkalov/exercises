package utils;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ToCypher {
    public static String adjacencyMapToCreateStatement( int numberOfNodes, Map<Integer, List<Integer>> graph, String nodeType ) {
        var result = new StringBuilder("CREATE\n");
        result.append(
                IntStream.range(0, numberOfNodes)
                        .mapToObj(intKey -> String.format("  (n%d:%s {num:%d})", intKey, nodeType, intKey))
                        .collect(Collectors.joining(",\n"))
        );
//        result.append(";\n");
        return result.toString();
    }
}
