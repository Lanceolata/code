package com.lanceolata.coding.algorithms.java.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Question_0699_Falling_Squares {
    public List<Integer> fallingSquares(int[][] positions) {
        int[] vPos = new int[positions.length * 2];
        for (int i = 0; i < positions.length; i++) {
            vPos[i * 2 + 0] = positions[i][0];
            vPos[i * 2 + 1] = positions[i][0] + positions[i][1];
        }
        Arrays.sort(vPos);

        List<Integer> ans = new ArrayList<>();
        int[] hs = new int[vPos.length];
        int totalMax = 0;

        for (int[] pos : positions) {
            // x, y
            int x = pos[0];
            int len = pos[1];
            int y = pos[0] + pos[1];

            int startIndex = Arrays.binarySearch(vPos, x);

            int maxH = 0;

            for (int i = startIndex; vPos[i] < y; i++) {
                maxH = Math.max(hs[i], maxH);
            }
            for (int i = startIndex; vPos[i] < y; i++) {
                hs[i] = maxH + len;
            }


            totalMax = Math.max(totalMax, maxH + len);
            ans.add(totalMax);
        }
        return ans;
    }
}
