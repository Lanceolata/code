package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0097_Interleaving_String {
    public boolean isInterleave(String s1, String s2, String s3) {
        if ((s1.length() + s2.length()) != s3.length()) {
            return false;
        }
        int m = s1.length(), n = s2.length();
        boolean[][] matrix = new boolean[m + 1][n + 1];
        matrix[0][0] = true;
        for (int i = 1; i <= m; i++) {
            matrix[i][0] = matrix[i - 1][0] && (s1.charAt(i - 1) == s3.charAt(i - 1));
        }
        for (int i = 1; i <= n; i++) {
            matrix[0][i] = matrix[0][i - 1] && (s2.charAt(i - 1) == s3.charAt(i - 1));
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                matrix[i][j] = (matrix[i][j - 1] && (s2.charAt(j - 1) == s3.charAt(i + j - 1)))
                        || (matrix[i - 1][j] && (s1.charAt(i - 1) == s3.charAt(i + j - 1)));
            }
        }
        return matrix[m][n];
    }
}
