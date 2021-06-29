package zyurkalov;


import java.util.*;

enum Colour{
    BLACK, WHITE, GRAY
}

class ThereIsLoop extends Exception {

}

public class CourseScheduleII {

    List<Integer> path = new ArrayList<>();
    Map<Integer, Colour> colourMap = new HashMap<>();

    public void dfs(int node, List<List<Integer>> graph) throws ThereIsLoop{
        if (this.colourMap.get(node) == Colour.BLACK)
            return;
        this.colourMap.put(node, Colour.GRAY);
        for (int neighbour : graph.get(node)) {
            Colour colourOfNode = this.colourMap.getOrDefault(neighbour, Colour.WHITE);
            if (colourOfNode == Colour.WHITE)
                dfs(neighbour, graph);
            else if (colourOfNode == Colour.GRAY) {
                path.clear();
                throw new ThereIsLoop();
            }
        }
        this.colourMap.put(node, Colour.BLACK);
        path.add(node);
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = convertToGraph(numCourses, prerequisites);
        for (int num = 0; num < graph.size(); num++) {
            try {
                dfs(num, graph);
            } catch (ThereIsLoop thereIsLoop) {
                return new int[0];
            }
        }
        Collections.reverse(path);
        return path.stream().mapToInt(obj->obj).toArray();
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
        int[] order = new CourseScheduleII().findOrder(4, a);
        for (int num : order) {
            System.out.println(num);
        }
    }
}
