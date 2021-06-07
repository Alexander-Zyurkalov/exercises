package json.another_dependent_package;

import java.util.*;
import java.io.*;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class Main {

    public static List<String> findTag(String str) {
        int start_pos = 0;
        List<String> list = new ArrayList<>();
        while(start_pos>=0 && start_pos < str.length()) {
            int opening = str.indexOf('<', start_pos);
            if (opening < 0) {
                return list;
            }
            int closing = str.indexOf('>', opening + 1);
            if (closing < 0) {
                return list;
            }
            list.add(str.substring(opening+1, closing));
            start_pos = closing + 1;
        }
        return  list;
    }

    public static boolean isOpening(String str) {
        return str.length() > 0 && str.charAt(0) != '/';
    }

    private int target;
    private int[][] graph;
    private List<List<Integer>> results;

    protected void backtrack(int currNode, LinkedList<Integer> path) {
        if (currNode == this.target) {
            // Note: one should make a deep copy of the path
            this.results.add(new ArrayList<Integer>(path));
            return;
        }
        // explore the neighbor nodes one after another.
        for (int nextNode : this.graph[currNode]) {
            // mark the choice, before backtracking.
            path.addLast(nextNode);
            this.backtrack(nextNode, path);
            // remove the previous choice, to try the next choice
            path.removeLast();
        }
    }

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {

        this.target = graph.length - 1;
        this.graph = graph;
        this.results = new ArrayList<List<Integer>>();
        // adopt the LinkedList for fast access to the tail element.
        LinkedList<Integer> path = new LinkedList<Integer>();
        path.addLast(0);
        // kick of the backtracking, starting from the source (node 0)
        this.backtrack(0, path);
        return this.results;
    }

    public static void main (String[] args) {
        int[][] graph = {{1, 2}, {3}, {3}, {}};
        System.out.println(new Main().allPathsSourceTarget(graph));
    }

}
