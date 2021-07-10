package zyurkalov;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConnectingCitiesWithMinimumCostTest {

    @Test
    public void minimumCost() {
        ConnectingCitiesWithMinimumCost connectingCitiesWithMinimumCost = new ConnectingCitiesWithMinimumCost();
        int result = connectingCitiesWithMinimumCost.minimumCost(3, new int[][]{{1, 2, 5}, {1, 3, 6}, {2, 3, 1}});
        assertEquals(6, result);

        int result2 = connectingCitiesWithMinimumCost.minimumCost(4, new int[][]{{1, 2, 3}, {3, 4, 4}});
        assertEquals(-1, result2);
    }

}
