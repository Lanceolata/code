package com.lanceolata.coding.algorithms.java.leetcode;

import java.util.Arrays;

public class Question_0205_Isomorphic_Strings {
    public boolean isIsomorphic(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }
        int[] m1 = new int[128], m2 = new int[128];
        Arrays.fill(m1, -1);
        Arrays.fill(m2, -1);
        for (int i = 0; i < s.length(); i++) {
            if (m1[s.charAt(i)] != m2[t.charAt(i)]) {
                return false;
            }
            m1[s.charAt(i)] = m2[t.charAt(i)] = i;
        }
        return true;
    }
}
