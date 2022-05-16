package com.lanceolata.coding.algorithms.java.leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class Question_0973_K_Closest_Points_to_Origin {
    public int[][] kClosest(int[][] points, int k) {
        Arrays.sort(points, Comparator.comparing(p -> p[0] * p[0] + p[1] * p[1]));
        return Arrays.copyOfRange(points, 0, k);
    }
}
