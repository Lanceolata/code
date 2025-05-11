package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0768_Max_Chunks_To_Make_Sorted_II {

    public int maxChunksToSorted(int[] arr) {
        //generate right min
        int[] rmin = new int[arr.length + 1];
        rmin[arr.length] = Integer.MAX_VALUE;

        for (int i = arr.length - 1; i >= 0; i--) {
            rmin[i] = Math.min(rmin[i + 1], arr[i]);
        }

        //iterate on array and manage left max as well as count chunks
        int lmax = Integer.MIN_VALUE;
        int count = 0;

        for (int i = 0; i < arr.length; i++) {

            lmax = Math.max(lmax, arr[i]);
            if (lmax <= rmin[i + 1]) {
                count++;
            }
        }
        return count;
    }
}
