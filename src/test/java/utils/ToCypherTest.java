package utils;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class ToCypherTest {

    @Test
    void adjacencyMapToCreateStatement() {
        int[][] richer = {{1,0},{2,1},{3,1},{3,7},{4,3},{5,3},{6,3}};
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] ints : richer) {
            int i = ints[1];
            graph.putIfAbsent(i, new ArrayList<>());
            graph.get(i).add(ints[0]);
        }

        String result = ToCypher.adjacencyMapToCreateStatement(8, graph, "RichPerson", "Richer");
        String expected =
                "CREATE\n" +
                "  (n0:RichPerson {num:0}),\n" +
                "  (n1:RichPerson {num:1}),\n" +
                "  (n2:RichPerson {num:2}),\n" +
                "  (n3:RichPerson {num:3}),\n" +
                "  (n4:RichPerson {num:4}),\n" +
                "  (n5:RichPerson {num:5}),\n" +
                "  (n6:RichPerson {num:6}),\n" +
                "  (n7:RichPerson {num:7}),\n" +
                "\n" +
                "  (n0) -[:Richer]-> (n1),\n" +
                "  (n1) -[:Richer]-> (n2),\n" +
                "  (n1) -[:Richer]-> (n3),\n" +
                "  (n3) -[:Richer]-> (n4),\n" +
                "  (n3) -[:Richer]-> (n5),\n" +
                "  (n3) -[:Richer]-> (n6),\n" +
                "  (n7) -[:Richer]-> (n3)" +
                "\n" +
                "return n0, n1, n2, n3, n4, n5, n6, n7;\n";

        assertEquals(expected, result);
    }
}
