package com.lanceolata.coding.algorithms.java.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Question_0054_Spiral_Matrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0) {
            return res;
        }
        int rStart = 0, rEnd = matrix.length - 1, cStart = 0, cEnd = matrix[0].length - 1;
        while (rStart <= rEnd && cStart <= cEnd) {
            for (int j = cStart; j <= cEnd; j++) {
                res.add(matrix[rStart][j]);
            }
            for (int i = rStart + 1; i <= rEnd; i++) {
                res.add(matrix[i][cEnd]);
            }
            if (rStart < rEnd && cStart < cEnd) {
                for (int j = cEnd - 1; j >= cStart; j--) {
                    res.add(matrix[rEnd][j]);
                }
                for (int i = rEnd - 1; i > rStart; i--) {
                    res.add(matrix[i][cStart]);
                }
            }
            rStart++; rEnd--; cStart++; cEnd--;
        }
        return res;
    }
}
