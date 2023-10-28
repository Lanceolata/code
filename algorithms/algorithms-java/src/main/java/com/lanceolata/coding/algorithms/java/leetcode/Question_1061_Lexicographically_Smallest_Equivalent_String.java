package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_1061_Lexicographically_Smallest_Equivalent_String {
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        char[] ch = new char[26];
        for (int i = 0; i < 26; i++) {
            ch[i] = (char) ('a' + i);
        }
        for (int i = 0; i < s1.length(); i++) {
            char c1 = ch[s1.charAt(i) - 'a'];
            char c2 = ch[s2.charAt(i) - 'a'];
            char toReplace = (char) Math.max(c1, c2);
            char replaceWith = (char) Math.min(c1, c2);
            for (int j = 0; j < 26; j++) {
                if (ch[j] == toReplace) {
                    ch[j] = replaceWith;
                }
            }
        }
        char[] res = baseStr.toCharArray();
        for (int i = 0; i < res.length; i++) {
            res[i] = ch[res[i] - 'a'];
        }
        return new String(res);
    }
}
