package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_1037_Valid_Boomerang {
    public boolean isBoomerang(int[][] points) {
        return (points[0][0] - points[1][0]) * (points[0][1] - points[2][1]) != (points[0][0] - points[2][0]) * (points[0][1] - points[1][1]);
    }
}
