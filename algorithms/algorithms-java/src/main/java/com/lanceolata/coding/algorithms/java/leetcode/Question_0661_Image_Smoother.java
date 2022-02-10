package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0661_Image_Smoother {
    private static int[] moves = {-1, 0, 1};

    public int[][] imageSmoother(int[][] img) {
        int m = img.length, n = img[0].length;
        int[][] res = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int sum = 0, cnt = 0;
                for (int x : moves) {
                    for (int y : moves) {
                        if (i + x < 0 || i + x >= m || j + y < 0 || j + y >= n) {
                            continue;
                        }
                        sum += img[i + x][j + y];
                        cnt++;
                    }
                }
                res[i][j] = sum / cnt;
            }
        }
        return res;
    }
}
