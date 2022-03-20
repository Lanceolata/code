package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0809_Expressive_Words {
    public int expressiveWords(String s, String[] words) {
        int res = 0;
        for (String w : words) {
            if (check(s, w)) {
                res++;
            }
        }
        return res;
    }

    private boolean check(String s, String w) {
        int i = 0, j = 0;
        while (i < s.length() && j < w.length()) {
            if (s.charAt(i) == w.charAt(j)) {
                int len1 = getRepeatedLength(s, i);
                int len2 = getRepeatedLength(w, j);
                if ((len1 < 3 && len1 != len2) || (len1 >= 3 && len1 < len2)) {
                    return false;
                }
                i += len1;
                j += len2;
            } else {
                return false;
            }
        }
        return i == s.length() && j == w.length();
    }

    private int getRepeatedLength(String s, int i) {
        int j = i;
        while (j < s.length() && s.charAt(i) == s.charAt(j)) {
            j++;
        }
        return j - i;
    }
}
