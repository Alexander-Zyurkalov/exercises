package utils;

import java.util.Random;
/* solution in Cypher, but it doesn't work when we have two sequences
match (n1:BestTimeToBuyAndSell)-[:NextDay*]->(n2:BestTimeToBuyAndSell) with n2.value - min(n1.value) as benefit return max(benefit)
 */
public class GenerateCypherForBestTimeToBuyAndSell {
    // https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
    public static void main(String[] args) {
        final int N = 100;
        System.out.println("CREATE ");
        int[] values = {7,6,4,3,1};
        for (int i = 1; i <= values.length; i++) {
//            int randomInt = new Random().nextInt(100) + 1;
            int randomInt = values[i-1];
            String createStatement = String.format("(N%d:BestTimeToBuyAndSell{value:%d}),", i, randomInt);
            System.out.println(createStatement);
            if (i > 1) {
                String linkThemStatement = String.format("    (N%d)-[:NextDay]->(N%d),", i - 1, i);
                System.out.println(linkThemStatement);
            }
        }
    }
}

