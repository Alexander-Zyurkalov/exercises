package zyurkalov.leetcode_solutions;

import java.util.ArrayList;
import java.util.List;

public class ParallelCoursesDFSSolution {
    public int minimumSemesters(int N, int[][] relations) {
        List<List<Integer>> graph = new ArrayList<>(N + 1); // graph is an organiser
        for (int i = 0; i < N + 1; ++i) {
            graph.add(new ArrayList<>());
        }
        for (int[] relation : relations) { // relation is a stepper
            graph.get(relation[0]).add(relation[1]);
        }
        // check if the graph contains a cycle
        int[] visitStatus = new int[N + 1]; // visitStatus is a flag
        for (int node = 1; node < N + 1; node++) { // node is a stepper
            // if has cycle, return -1
            if (dfsCheckCycle(node, graph, visitStatus) == -1) {
                return -1;
            }
        }

        // if no cycle, return the longest path
        int[] visitedLength = new int[N + 1];
        int maxLength = 1; // maxLength is a MostWantedHolder
        for (int node = 1; node < N + 1; node++) { // node is a stepper
            int length = dfsMaxPath(node, graph, visitedLength);
            maxLength = Math.max(length, maxLength);
        }
        return maxLength;
    }

    private int dfsCheckCycle(int node, List<List<Integer>> graph, int[] visitStatus) {
        // return -1 if has a cycle
        // return 1 if does not have any cycle
        if (visitStatus[node] != 0) {
            return visitStatus[node];
        } else {
            // mark as visiting
            visitStatus[node] = -1;
        }
        for (int endNode : graph.get(node)) { // endNode is a stepper
            if (dfsCheckCycle(endNode, graph, visitStatus) == -1) {
                // we meet a cycle!
                return -1;
            }
        }
        // mark as visitStatus
        visitStatus[node] = 1;
        return 1;
    }

    private int dfsMaxPath(int node, List<List<Integer>> graph, int[] visitedLength) {
        // return the longest path (inclusive)
        if (visitedLength[node] != 0) {
            return visitedLength[node];
        }
        int maxLength = 1; // maxLength is the most wanted holder
        for (int endNode : graph.get(node)) { // endNode is a stepper
            int length = dfsMaxPath(endNode, graph, visitedLength);
            maxLength = Math.max(length + 1, maxLength);
        }
        // store it
        visitedLength[node] = maxLength;
        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(new ParallelCoursesDFSSolution().minimumSemesters(3, new int[][]{{1,3},{2,3}}));
    }
}
