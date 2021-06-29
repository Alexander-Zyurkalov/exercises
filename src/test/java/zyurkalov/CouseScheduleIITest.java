package zyurkalov;

import com.google.common.collect.Lists;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

class CouseScheduleIITest {

    @Test
    void convertToGraph() {
        List<List<Integer>> result = new CouseScheduleII().convertToGraph(4, new int[][]{{1, 0}, {2, 0}, {3, 1}, {3, 2}});
        var expectedArray = new int[][]{{1, 2}, {3}, {3}, {}};
        List<List<Integer>> expected = new ArrayList<>();
        for (int[] sub : expectedArray) {
            var subList = new ArrayList<Integer>();
            for (var el : sub) {
                subList.add(el);
            }
            expected.add(subList);
        }
        assertEquals(expected, result);
    }
}
