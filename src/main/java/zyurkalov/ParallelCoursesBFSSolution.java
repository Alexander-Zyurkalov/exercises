package zyurkalov;

import utils.AdjacencyMap;
import utils.ToAdjacencyMap;

import java.util.*;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class ParallelCoursesBFSSolution {
    public int minimumSemesters(int N, int[][] relations) {
        AdjacencyMap graph = ToAdjacencyMap.fromPairs(relations);
        int[] nodeIndegrees = calculateNodeIndegrees(N, relations);
        int semestrCounter = 0;
        int courseCounter = 0;
        List<Integer> courseQueue = findCoursesWithNoDependencies(nodeIndegrees);
        while (!courseQueue.isEmpty()) {
            semestrCounter ++;
            List<Integer> nextCourseQueue = new ArrayList<>();
            for (int course : courseQueue) {
                courseCounter++;
                nodeIndegrees[course] --;
                nextCourseQueue.addAll(findCoursesWithNoDependencies(nodeIndegrees));
            }
            courseQueue = nextCourseQueue;
        }

        return courseCounter == N ? semestrCounter : -1;
    }

    private List<Integer> findCoursesWithNoDependencies(int[] nodeDegrees) {
        return IntStream.range(1, nodeDegrees.length).filter(i -> nodeDegrees[i] == 0).boxed().collect(toList());
    }


    private int[] calculateNodeIndegrees(int n, int[][] relations) {
        int[] result = new int[n+1];
        for (int[] relation : relations) {
            result[relation[1]]++;
        }
        return result;
    }


    public static void main(String[] args) {
        System.out.println(new ParallelCoursesBFSSolution().minimumSemesters(3, new int[][]{{1,3},{2,3}}));
    }
}
