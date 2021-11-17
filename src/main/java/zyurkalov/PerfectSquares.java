package zyurkalov;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/*
https://leetcode.com/problems/perfect-squares/
Given an integer n, return the least number of perfect square numbers that sum to n.

A perfect square is an integer that is the square of an integer; in other words, it is the product of some integer with itself. For example, 1, 4, 9, and 16 are perfect squares while 3 and 11 are not.



Example 1:

Input: n = 12
Output: 3
Explanation: 12 = 4 + 4 + 4.
Example 2:

Input: n = 13
Output: 2
Explanation: 13 = 4 + 9.

 */
public class PerfectSquares {

    public int numSquares(int n) {
        int[] squares = IntStream.iterate(1, num -> num < (Math.sqrt(n)) + 1, num -> num + 1).map(num -> num * num).toArray();
        if (Arrays.binarySearch(squares, n) > 0 || n <= 1)
            return 1;
        int minNum = Integer.MAX_VALUE;
        for (int square: squares) {
            if (square > n)
                break;
            int newNum = numSquares(n-square) + 1;
            minNum = Integer.min(minNum, newNum);
        }
        return minNum;
    }

    public static void main(String[] args) {
        System.out.println(new PerfectSquares().numSquares(1) == 1);
        System.out.println(new PerfectSquares().numSquares(16) == 1);
        System.out.println(new PerfectSquares().numSquares(12) == 3);
        System.out.println(new PerfectSquares().numSquares(13) == 2);
        System.out.println(new PerfectSquares().numSquares(0) == 1);
    }
}
