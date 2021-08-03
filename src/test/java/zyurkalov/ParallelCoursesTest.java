package zyurkalov;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParallelCoursesTest {

    @Test
    void minimumSemesters() {
        int actual = new ParallelCourses().minimumSemesters(3, new int[][]{{1,3},{2,3}});
        assertEquals(2, actual);
    }
}
