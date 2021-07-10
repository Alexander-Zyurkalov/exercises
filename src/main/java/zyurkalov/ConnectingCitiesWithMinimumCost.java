package zyurkalov;

import java.util.Arrays;
import java.util.Comparator;

public class ConnectingCitiesWithMinimumCost {
    private final static int NODE1 = 0;
    private final static int NODE2 = 1;
    private final static int WEIGHT = 2;
    public int minimumCost(int n, int[][] connections) {

        int sum = Arrays.stream(connections)
                .sorted(Comparator.comparingInt(connection -> connection[WEIGHT]))
                .peek(connection -> {

                })
                .mapToInt(connection -> connection[WEIGHT])
                .sum();
        return sum;

    }

    public static void main(String[] args) {
        ConnectingCitiesWithMinimumCost connectingCitiesWithMinimumCost = new ConnectingCitiesWithMinimumCost();
        System.out.println(
                connectingCitiesWithMinimumCost.minimumCost(3,
                        new int[][]{{1,2,5},{1,3,6},{2,3,1}})
        );
    }
}
