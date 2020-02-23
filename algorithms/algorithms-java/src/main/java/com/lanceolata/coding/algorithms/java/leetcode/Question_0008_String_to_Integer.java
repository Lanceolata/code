package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0008_String_to_Integer {
    public int myAtoi(String str) {
        if (str == null) {
            return 0;
        }
        int i = 0;
        while (i < str.length() && str.charAt(i) == ' ') {
            i++;
        }
        int sign = 1;
        if (i < str.length() && (str.charAt(i) == '-' || str.charAt(i) == '+')) {
            if (str.charAt(i++) == '-') {
                sign = -1;
            }
        }
        int res = 0;
        while (i < str.length() && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
            int pop = str.charAt(i++) - '0';
            if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && pop > 7)) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            res = res * 10 + pop;
        }
        return sign * res;
    }
}
