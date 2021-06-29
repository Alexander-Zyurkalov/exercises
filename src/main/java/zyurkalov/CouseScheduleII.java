package zyurkalov;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

class CouseScheduleII {

    Stack<Integer> stack = new Stack<>();
    public void dfs(int node, int[][] prerequisites){
        for (int neighbour : prerequisites[node]) {
            dfs(neighbour, prerequisites);
        }
        stack.add(node);
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = convertToGraph(numCourses, prerequisites);
        dfs(0, prerequisites);
        ArrayList<Integer> list = new ArrayList<>();

        return stack.stream().mapToInt(obj-> obj).toArray();
    }

    public List<List<Integer>> convertToGraph(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>(numCourses);
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] prerequisite : prerequisites) {
            graph.get(prerequisite[1]).add(prerequisite[0]);
        }
        return graph;
    }

    public static void main(String[] args) {
        int[][]a = {{1,0},{2,0},{3,1},{3,2}};
        int[] order = new CouseScheduleII().findOrder(4, a);
        for (int num : order) {
            System.out.println(num);
        }
    }
}
