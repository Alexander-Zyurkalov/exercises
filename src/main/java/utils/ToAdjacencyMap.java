package utils;

import java.util.ArrayList;

public class ToAdjacencyMap {

    public static AdjacencyMap fromPairs(int[][] pairs) {
        return getMap(pairs, 0, 1);
    }
    public static AdjacencyMap parentMapFromPairs(int[][] pairs) {
        return getMap(pairs, 1, 0);
    }

    private static AdjacencyMap getMap(int[][] pairs, int i2, int i3) {
        AdjacencyMap graph = new AdjacencyMap();
        for (int[] ints : pairs) {
            int i = ints[i2];
            graph.putIfAbsent(i, new ArrayList<>());
            graph.putIfAbsent(ints[i3], new ArrayList<>());
            graph.get(i).add(ints[i3]);
        }
        return graph;
    }

}
