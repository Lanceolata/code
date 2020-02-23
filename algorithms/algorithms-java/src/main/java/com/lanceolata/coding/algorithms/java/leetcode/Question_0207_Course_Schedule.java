package com.lanceolata.coding.algorithms.java.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Question_0207_Course_Schedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (prerequisites == null || prerequisites.length == 0) {
            return true;
        }
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<Integer>());
        }
        int[] inDegree = new int[numCourses];
        for (int[] pre : prerequisites) {
            int c = pre[0], p = pre[1];
            graph.get(p).add(c);
            inDegree[c]++;
        }
        Queue<Integer> que = new LinkedList<Integer>();
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) {
                que.add(i);
            }
        }
        while (!que.isEmpty()) {
            int i = que.poll();
            for (int j : graph.get(i)) {
                inDegree[j]--;
                if (inDegree[j] == 0) {
                    que.add(j);
                }
            }
        }
        for (int i : inDegree) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }
}
