package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0942_DI_String_Match {
    public int[] diStringMatch(String s) {
        int l = 0, r = s.length(), i = 0;
        int[] res = new int[s.length() + 1];
        for (char c : s.toCharArray()) {
            if (c == 'I') {
                res[i++] = l++;
            } else {
                res[i++] = r--;
            }
        }
        res[i] = l;
        return res;
    }
}
