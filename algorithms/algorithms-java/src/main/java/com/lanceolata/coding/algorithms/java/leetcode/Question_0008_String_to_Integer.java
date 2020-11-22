package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0008_String_to_Integer {
    public int myAtoi(String s) {
        if (s == null) {
            return 0;
        }
        int i = 0;
        while (i < s.length() && s.charAt(i) == ' ') {
            i++;
        }
        int sign = 1;
        if (i < s.length() && (s.charAt(i) == '-' || s.charAt(i) == '+')) {
            if (s.charAt(i++) == '-') {
                sign = -1;
            }
        }
        int res = 0;
        while (i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
            int pop = s.charAt(i++) - '0';
            if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && pop > 7)) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            res = res * 10 + pop;
        }
        return sign * res;
    }
}
