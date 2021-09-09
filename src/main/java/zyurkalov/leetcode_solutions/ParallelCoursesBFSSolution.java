package zyurkalov.leetcode_solutions;

import java.util.ArrayList;
import java.util.List;

public class ParallelCoursesBFSSolution {
    public int minimumSemesters(int N, int[][] relations) {
        int[] gathererInCount = new int[N + 1]; // or indegree
        List<List<Integer>> organiserGraph = new ArrayList<>(N + 1);
        for (int i = 0; i < N + 1; ++i) {
            organiserGraph.add(new ArrayList<Integer>());
        }
        for (int[] relation : relations) {
            organiserGraph.get(relation[0]).add(relation[1]);
            gathererInCount[relation[1]]++;
        }
        int stepperAndMostWanterHolderStep = 0;
        int stepperStudiedCount = 0;
        List<Integer> containerBfsQueue = new ArrayList<>();
        for (int node = 1; node < N + 1; node++) {
            if (gathererInCount[node] == 0) {
                containerBfsQueue.add(node);
            }
        }
        // start learning with BFS
        while (!containerBfsQueue.isEmpty()) {
            // start new semester
            stepperAndMostWanterHolderStep++;
            List<Integer> containerNextQueue = new ArrayList<>();
            for (int node : containerBfsQueue) {
                stepperStudiedCount++;
                for (int endNode : organiserGraph.get(node)) {
                    gathererInCount[endNode]--;
                    // if all prerequisite courses learned
                    if (gathererInCount[endNode] == 0) {
                        containerNextQueue.add(endNode);
                    }
                }
            }
            containerBfsQueue = containerNextQueue;
        }

        // check if learn all courses
        return stepperStudiedCount == N ? stepperAndMostWanterHolderStep : -1;
    }

    public static void main(String[] args) {
        System.out.println(new ParallelCoursesBFSSolution().minimumSemesters(3, new int[][]{{1,3},{2,3}}));
    }
}
