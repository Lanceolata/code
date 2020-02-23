package com.lanceolata.coding.algorithms.java.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Question_0438_Find_All_Anagrams_in_a_String {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if (s.isEmpty()) {
            return res;
        }
        int[] m = new int[128];
        for (int i = 0; i < p.length(); i++) {
            m[p.charAt(i)]++;
        }
        int cnt = p.length();
        for (int i = 0, j = 0; j < s.length(); j++) {
            if (m[s.charAt(j)]-- > 0) {
                cnt--;
            }
            if (cnt == 0) {
                res.add(i);
            }
            if (j - i + 1 == p.length() && m[s.charAt(i++)]++ >= 0) {
                cnt++;
            }
        }
        return res;
    }
}
