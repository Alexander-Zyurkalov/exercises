package zyurkalov;
// https://leetcode.com/problems/parallel-courses/

import utils.AdjacencyMap;
import utils.ToAdjacencyMap;

import java.util.Arrays;
import java.util.Comparator;


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

        AdjacencyMap relationMap = ToAdjacencyMap.parentMapFromPairs(relations);
        for (int i = 1; i <= n; i++) {
            try {
                dfs(i, relationMap);
            } catch (LoopException e) {
                return -1;
            }
        }
        return (int)Arrays.stream(nodesOrder).filter(val -> val >= 0).distinct().count();
    }

    private int dfs(int i, AdjacencyMap relationMap) throws LoopException {
        if (nodeStates[i - 1] == NodeState.DONE)
            return nodesOrder[i - 1];
        else if (nodeStates[i - 1] == NodeState.PROCESSING)
            throw new LoopException();
        nodeStates[i-1] = NodeState.PROCESSING;
        int the_max_length = relationMap.get(i).stream()
                .peek(num -> dfs(num, relationMap))
                .reduce(i, (n1, n2) -> n1 > n2 ? n1 : n2);
        nodesOrder[i-1] = the_max_length;
        nodeStates[i-1] = NodeState.DONE;
        return the_max_length;
    }


}
