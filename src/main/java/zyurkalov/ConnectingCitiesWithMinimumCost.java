package zyurkalov;

public class ConnectingCitiesWithMinimumCost {
    public int minimumCost(int n, int[][] connections) {
        return 3;

    }

    public static void main(String[] args) {
        ConnectingCitiesWithMinimumCost connectingCitiesWithMinimumCost = new ConnectingCitiesWithMinimumCost();
        System.out.println(
                connectingCitiesWithMinimumCost.minimumCost(3,
                        new int[][]{{1,2,5},{1,3,6},{2,3,1}})
        );
    }
}
