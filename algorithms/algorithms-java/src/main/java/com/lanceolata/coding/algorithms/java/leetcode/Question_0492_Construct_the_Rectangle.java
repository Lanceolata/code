package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0492_Construct_the_Rectangle {
    public int[] constructRectangle(int area) {
        int i = (int)Math.sqrt(area);
        while (area % i != 0) {
            i--;
        }
        return new int[] {area / i, i};
    }
}
