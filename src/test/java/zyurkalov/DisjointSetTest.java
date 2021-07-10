package zyurkalov;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DisjointSetTest {

    @Test
    void union() {
        // 0--------1--8
        //  \       \
        //    2--3   9-10
        // 5 - 6 - 7
        // 4
        var ds = new DisjointSet(11);
        ds.union(0, 1);
        ds.union(0, 2);
        ds.union(1, 8);
        ds.union(1, 9);
        ds.union(9, 10);
        ds.union(2, 3);
        ds.union(5, 6);
        ds.union(6, 7);
        assertArrayEquals(
                new int[]{0, 0, 0, 0, 4, 5, 5, 5, 0, 0, 0},
                ds.getParents()
        );

    }
}
