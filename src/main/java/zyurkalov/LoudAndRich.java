package zyurkalov;

import java.util.*;
import java.util.stream.IntStream;

public class LoudAndRich {

    private static class DFS{
        private final Map<Integer, List<Integer>> graph;
        private final int[] quiet;
        private Deque<Integer> visited = new LinkedList<>();

        public DFS(final Map<Integer, List<Integer>> graph, final int[] quiet) {
            this.graph = graph;
            this.quiet = quiet;
        }
        public int dfs(int i){
            if (!graph.containsKey(i) || graph.get(i).size() == 0)
                return i;
            return graph.get(i).stream()
//                    .peek(num->visited)
                    .map(this::dfs)
                    .reduce(i, (num1, num2 )-> quiet[num1] < quiet[num2] ? num1 : num2);
        }
    }

    public int[] loudAndRich(int[][] richer, int[] quiet) {
        Map<Integer, List<Integer>> graph = new HashMap<>(quiet.length);
        for (int[] ints : richer) {
            int i = ints[1];
            graph.putIfAbsent(i, new ArrayList<>());
            graph.get(i).add(ints[0]);
        }
        var dfs = new DFS(graph, quiet);
        return IntStream.range(0,quiet.length).map(dfs::dfs).toArray();
    }



    public static void main(String[] args) {

        var output = Arrays.toString(new LoudAndRich().loudAndRich(
                new int[][]{{1,0},{2,1},{3,1},{3,7},{4,3},{5,3},{6,3}},
                new int[]{3,2,5,4,6,1,7,0}
        ));
        System.out.println(output);
    }
}



