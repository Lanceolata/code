package com.lanceolata.coding.algorithms.java.leetcode;

import java.util.Arrays;

public class Question_0424_Longest_Repeating_Character_Replacement {
    public int characterReplacement(String s, int k) {
        int res = 0, maxCount = 0;
        int[] indexes = new int[26];
        Arrays.fill(indexes, 0);
        for (int i = 0, j = 0; j < s.length(); j++) {
            maxCount = Math.max(maxCount, ++indexes[s.charAt(j) - 'A']);
            while (j - i + 1 - maxCount > k) {
                --indexes[s.charAt(i) - 'A'];
                i++;
            }
            res = Math.max(res, j - i + 1);
        }
        return res;
    }
}
