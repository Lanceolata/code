package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0467_Unique_Substrings_in_Wraparound_String {
    public int findSubstringInWraproundString(String p) {
        int[] cnt = new int[26];
        int res = 0, len = 0;
        for (int i = 0; i < p.length(); ++i) {
            int cur = p.charAt(i) - 'a';
            if (i > 0 && p.charAt(i - 1) != (cur + 26 - 1) % 26 + 'a') {
                len = 0;
            }
            if (++len > cnt[cur]) {
                res += len - cnt[cur];
                cnt[cur] = len;
            }
        }
        return res;
    }
}
