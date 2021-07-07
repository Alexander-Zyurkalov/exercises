package zyurkalov;

import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.IntStream;

public class NumberOfProvinces {

    private int dfs(int node, int[]visited, int[][] isConnected) {
        return (int)IntStream.range(0, isConnected[node].length)
                .filter(i -> isConnected[node][i] == 1 && visited[i] == 0)
                .peek(i -> visited[i] = 1)
                .map(i -> dfs(i, visited, isConnected))
                .count();
    };


    public int findCircleNum(int[][] isConnected) {
        int[] visited = new int[isConnected.length];
        return IntStream.range(0, isConnected.length)
                .filter(i -> visited[i] == 0)
                .map(i->dfs(i, visited, isConnected))
                .sum();
    }

    public int findCircleNumBFS(int[][] isConnected) {
        int[] visited = new int[isConnected.length];
        int count = 0;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < isConnected.length; i++) {
            if (visited[i] == 0) {
                queue.add(i);
            }
            while (!queue.isEmpty()) {
                int s = queue.remove();
                visited[s] = 1;
                for (int j = 0; j < isConnected.length; j++) {
                    if (isConnected[s][j] == 1 && visited[j] == 0)
                        queue.add(j);
                }
            }
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(
                new NumberOfProvinces().findCircleNum(new int[][]{{1,1,0},{1,1,0},{0,0,1}})
        );
    }

}
