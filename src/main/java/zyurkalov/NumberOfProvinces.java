package zyurkalov;

import java.util.Arrays;
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

    // it finds number of clusters of connected nodes by counting not visited nodes at the high level of the
    // algorithm.
    // 1 - 2       4 - 5 - 6
    //  \      +    \          = 2
    //    3          7
    public int findCircleNumBFS(int[][] isConnected) {
        int[] visited = new int[isConnected.length];
        int count = 0;
        Queue < Integer > queue = new LinkedList < > ();
        for (int i = 0; i < isConnected.length; i++) {
            if (visited[i] == 0) { // here we count not visited nodes because in while-loop we will visit all connected
                queue.add(i);
                while (!queue.isEmpty()) {
                    int s = queue.remove();
                    visited[s] = 1;
                    System.out.println("Visited " + s);
                    for (int j = 0; j < isConnected.length; j++) {
                        if (isConnected[s][j] == 1 && visited[j] == 0)
                            queue.add(j);
                    }
                }
                count++;
            }
        }
        return count;
    }


    int find(int parent[], int node) {
        if (parent[node] == -1)
            return node;
        return find(parent, parent[node]);
    }

    void union(int parent[], int i, int j) {
        int xset = find(parent, i);
        int yset = find(parent, j);
        if (xset != yset)
            parent[xset] = yset;
    }

    public int findCircleNumUnion(int[][] M) {
        int[] parent = new int[M.length];
        Arrays.fill(parent, -1);
        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M.length; j++) {
                if (M[i][j] == 1 && i != j) {
                    union(parent, i, j);
                }
            }
        }
        int count = 0;
        for (int i = 0; i < parent.length; i++) {
            if (parent[i] == -1)
                count++;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(
                new NumberOfProvinces().findCircleNumUnion(
                        new int[][]
                                {
                                        {1, 1, 0, 0, 0, 0},
                                        {1, 1, 0, 0, 0, 0},
                                        {0, 0, 1, 1, 1, 0},
                                        {0, 0, 1, 1, 0, 0},
                                        {0, 0, 1, 0, 1, 0},
                                        {0, 0, 0, 0, 0, 1}}
                )
        );
    }

}
