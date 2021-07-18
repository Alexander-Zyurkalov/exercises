package utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class toAdjacencyMap {

    public static Map<Integer, List<Integer>> fromPairs(int[][] pairs) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] ints : pairs) {
            int i = ints[1];
            graph.putIfAbsent(i, new ArrayList<>());
            graph.get(i).add(ints[0]);
        }
        return graph;
    }
}
