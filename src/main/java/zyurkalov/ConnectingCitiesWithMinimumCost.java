package zyurkalov;

import java.util.Arrays;
import java.util.Comparator;


class DisjointSet {
    private final int[] parents;
    public DisjointSet(int n) {
        this.parents = new int[n];
        for (int i = 0; i < this.parents.length; i++) {
            this.parents[i] = i;
        }
    }

    public void union(int node1, int node2) {
        int parent_for_node1 = find(node1);
        int parent_for_node2 = find(node2);
        if (parent_for_node1 == parent_for_node2) return;
        this.parents[parent_for_node2] = parent_for_node1;
    }

    private int find(int node) {
        int parent_of_node = node;
        while (parent_of_node != this.parents[parent_of_node]) {
            parent_of_node = this.parents[parent_of_node];
        }
        return parent_of_node;
    }

    public int[] getParents() {
        return Arrays.copyOf(parents, parents.length);
    }

    public boolean isInTheSameGroup(int node1, int node2) {
        return find(node1) == find(node2);
    }
}


public class ConnectingCitiesWithMinimumCost {
    private final static int NODE1 = 0;
    private final static int NODE2 = 1;
    private final static int WEIGHT = 2;

    public int minimumCost(int n, int[][] connections) {
        DisjointSet disjointSet = new DisjointSet(n);
        int sum = Arrays.stream(connections)
                .sorted(Comparator.comparingInt(connection -> connection[WEIGHT]))
                .filter(connection -> !disjointSet.isInTheSameGroup(connection[NODE1], connection[NODE2]))
                .peek(connection -> disjointSet.union(connection[NODE1], connection[NODE2]))
                .mapToInt(connection -> connection[WEIGHT])
                .sum();
        return sum;

    }

    public static void main(String[] args) {
        ConnectingCitiesWithMinimumCost connectingCitiesWithMinimumCost = new ConnectingCitiesWithMinimumCost();
        System.out.println(
                connectingCitiesWithMinimumCost.minimumCost(3,
                        new int[][]{{0,1,5},{0,2,6},{1,2,1}})
        );
    }
}
