package zyurkalov;

import java.util.Arrays;

public class CodityDemo {

    public int solution(int[] A) {
        int[] array = Arrays.stream(A).filter(a -> a > 0).sorted().toArray();
        for (int i = 0; i < array.length; i++) {
            if (i == array.length-1 || array[i+1] - array[i] > 1)
                return array[i] + 1;
        }
        return 1;
    }

    public static void main(String[] args) {
        System.out.println(new CodityDemo().solution(new int[]{1, 2, 3}));
    }
}
