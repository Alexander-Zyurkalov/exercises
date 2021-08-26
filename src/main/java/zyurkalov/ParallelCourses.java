package zyurkalov;
// https://leetcode.com/problems/parallel-courses/

import utils.AdjacencyMap;
import utils.ToAdjacencyMap;

import java.util.Arrays;
import java.util.stream.Collectors;


class LoopException extends RuntimeException { }

enum NodeState {
    UNTOUCHED,
    PROCESSING,
    DONE
}

public class ParallelCourses {
    int[] nodesOrder;
    NodeState[] nodeStates;

    public int minimumSemesters(int n, int[][] relations) {
        nodesOrder = new int[n];
        nodeStates = new NodeState[n];
        Arrays.fill(nodesOrder, -1);
        Arrays.fill(nodeStates, NodeState.UNTOUCHED);

        AdjacencyMap relationMap = ToAdjacencyMap.parentMapFromPairs(
                Arrays.stream(relations)
                        .map(
                                value -> new int[]{value[0] - 1, value[1] - 1}
                        )
                        .collect(Collectors.toList())
                        .toArray(new int[][]{}));
        for (int i = 0; i < n; i++) {
            try {
                dfs(i, relationMap);
            } catch (LoopException e) {
                return -1;
            }
        }
        return (int)Arrays.stream(nodesOrder).filter(val -> val >= 0).distinct().count();
    }


    private void dfs(final int i, final AdjacencyMap relationMap) throws LoopException {
        dfs(i, relationMap, 0);
    }
    private int dfs(final int i, final AdjacencyMap relationMap, final int depth) throws LoopException {
        if (nodeStates[i] == NodeState.DONE)
            return nodesOrder[i];
        else if (nodeStates[i] == NodeState.PROCESSING)
            throw new LoopException();
        nodeStates[i] = NodeState.PROCESSING;
        int the_max_length = relationMap.get(i).stream()
                .map(num -> dfs(num, relationMap, depth + 1) + 1)
                .reduce(depth, (n1, n2) -> n1 > n2 ? n1 : n2);
        nodesOrder[i] = the_max_length;
        nodeStates[i] = NodeState.DONE;
        return the_max_length;
    }


}
