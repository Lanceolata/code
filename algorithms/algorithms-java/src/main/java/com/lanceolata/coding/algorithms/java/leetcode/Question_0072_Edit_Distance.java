package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0072_Edit_Distance {
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        // if one of the strings is empty
        if (n * m == 0)
            return n + m;

        // array to store the convertion history
        int[][] d = new int[n + 1][m + 1];

        // init boundaries
        for (int i = 0; i < n + 1; i++) {
            d[i][0] = i;
        }
        for (int j = 0; j < m + 1; j++) {
            d[0][j] = j;
        }

        // DP compute
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                // 删除
                // d[i - 1][j] 是 A[0,i-1] -> B[0,j] 的编辑次数
                // 对于(i,j)，A[i]删除
                int left = d[i - 1][j] + 1;
                // 插入
                // d[i][j - 1] 是 A[0, i]到B[0, j-1] 的编辑次数
                // 对于(i,j)，B[j]插入到A[i]
                int down = d[i][j - 1] + 1;
                // 替换
                // d[i - 1][j -1] 是 A[0,i-1] -> B[0,j-1] 的编辑次数
                // 对于(i,j)，A[i]替换成B[j]
                // 如果字符相等则不需要替换
                int left_down = d[i - 1][j - 1];
                if (word1.charAt(i - 1) != word2.charAt(j - 1)) {
                    left_down += 1;
                }
                d[i][j] = Math.min(left, Math.min(down, left_down));

            }
        }
        return d[n][m];
    }
}
