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


    private List<List<Integer>> backtrack(int current, int target, int[][] graph, Deque<Integer> path) {
        List<List<Integer>> result = new ArrayList<>();
        if (current == target) {
            result.add(new ArrayList<Integer>(path));
            return result;
        }
        for (int nextNode: graph[current]) {
            path.addLast(nextNode);
            result.addAll(backtrack(nextNode, target, graph, path));
            path.removeLast();
        }
        return result;
    }

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        var target = graph.length - 1;

        LinkedList<Integer> path = new LinkedList<>();
        path.addLast(0);
        return backtrack(0, target, graph, path);

    }

    public static void main (String[] args) {
        int[][] graph = {{1, 2}, {3}, {3}, {}};
        System.out.println(new Main().allPathsSourceTarget(graph));
    }

}
