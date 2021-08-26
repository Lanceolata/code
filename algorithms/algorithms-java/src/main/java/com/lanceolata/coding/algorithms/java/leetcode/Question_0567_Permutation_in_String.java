package com.lanceolata.coding.algorithms.java.leetcode;

import java.util.Arrays;

public class Question_0567_Permutation_in_String {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }
        int[] index = new int[256];
        Arrays.fill(index, 0);
        for (int i = 0; i < s1.length(); i++) {
            index[s1.charAt(i)]++;
        }
        int cnt = 0;
        for (int i = 0, j = 0; j < s2.length(); j++) {
            if (j >= s1.length() && index[s2.charAt(i++)]++ >= 0) {
                cnt--;
            }
            if (index[s2.charAt(j)]-- > 0) {
                cnt++;
            }
            if (cnt == s1.length()) {
                return true;
            }
        }
        return false;
    }
}
