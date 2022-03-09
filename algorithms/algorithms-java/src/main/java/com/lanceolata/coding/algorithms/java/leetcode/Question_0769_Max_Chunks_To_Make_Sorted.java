package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0769_Max_Chunks_To_Make_Sorted {
    public int maxChunksToSorted(int[] arr) {
        int res = 0, maxI = 0;
        for (int i = 0; i < arr.length; i++) {
            maxI = Math.max(maxI, arr[i]);
            if (maxI == i) {
                ++res;
            }
        }
        return res;
    }
}
