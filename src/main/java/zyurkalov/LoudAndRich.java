package zyurkalov;

import java.util.Arrays;

public class LoudAndRich {
    public int[] loudAndRich(int[][] richer, int[] quiet) {
        return new int[]{};
    }

    public static void main(String[] args) {
        var output = Arrays.toString(new LoudAndRich().loudAndRich(
                new int[][]{{1,0},{2,1},{3,1},{3,7},{4,3},{5,3},{6,3}},
                new int[]{3,2,5,4,6,1,7,0}
        ));
        System.out.println(output);
    }
}
