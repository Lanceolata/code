package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0378_Kth_Smallest_Element_in_a_Sorted_Matrix {
    public int kthSmallest(int[][] matrix, int k) {
        int l = matrix[0][0], r = matrix[matrix.length - 1][matrix[0].length - 1], m;
        while (l <= r) {
            m = l + (r - l) / 2;
            int cnt = help(matrix, m);
            if (cnt < k) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return l;
    }

    private int help(int[][] matrix, int n) {
        int res = 0;
        for (int i = 0; i < matrix.length; i++) {
            int j = matrix[0].length - 1;
            while (j >= 0 && matrix[i][j] > n) {
                j--;
            }
            res += j + 1;
        }
        return res;
    }
}
