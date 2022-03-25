package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0836_Rectangle_Overlap {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        boolean up = rec1[1] >= rec2[3];
        boolean down = rec1[3] <= rec2[1];
        boolean left = rec1[2] <= rec2[0];
        boolean right = rec1[0] >= rec2[2];
        return !(up || down || left || right);
    }
}
