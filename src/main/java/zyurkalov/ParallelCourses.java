package zyurkalov;
// https://leetcode.com/problems/parallel-courses/

import utils.AdjacencyMap;
import utils.ToAdjacencyMap;

import java.util.Arrays;
import java.util.Comparator;

public class ParallelCourses {
    int[] nodes_order;

    public int minimumSemesters(int n, int[][] relations) {
        nodes_order = new int[n];
        Arrays.fill(nodes_order, -1);

        AdjacencyMap relationMap = ToAdjacencyMap.parentMapFromPairs(relations);
        for (int i = 1; i <= n; i++) {
            dfs(i, relationMap);
        }
        return (int)Arrays.stream(nodes_order).filter(val -> val >= 0).distinct().count();
    }

    private int dfs(int i, AdjacencyMap relationMap) {
        if (relationMap.get(i).size() == 0) {
            nodes_order[i-1] = i;
            return i;
        }
        int the_max_length =  relationMap.get(i).stream()
                .max(Comparator.comparingInt(num -> dfs(num, relationMap)))
                .orElse(-1);
        nodes_order[i-1] = the_max_length;
        return the_max_length;
    }


}
