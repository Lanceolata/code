package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0394_Decode_String {
    private int i;

    public String decodeString(String s) {
        if (s == null) {
            return s;
        }
        i = 0;
        return decode(s);
    }

    private String decode(String s) {
        StringBuilder res = new StringBuilder();
        while (i < s.length() && s.charAt(i) != ']') {
            if (s.charAt(i) < '0' || s.charAt(i) > '9') {
                res.append(s.charAt(i++));
            } else {
                int cnt = 0;
                while (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                    cnt = cnt * 10 + (s.charAt(i++) - '0');
                }
                ++i;
                String t = decode(s);
                ++i;
                while (cnt-- > 0) {
                    res.append(t);
                }
            }
        }
        return res.toString();
    }
}
