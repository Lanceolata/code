package com.lanceolata.coding.algorithms.java.coding_interviews_2;

public class Question_0067_StringToInt {
    public int StrToInt(String str) {
        if (str == null || str.isEmpty()) {
            return 0;
        }
        int i = 0, res = 0, sign = 1, tmp;
        if (str.charAt(i) == '+' || str.charAt(i) == '-') {
            if (str.charAt(i) == '-') {
                sign = -1;
            }
            i++;
        }
        while (i < str.length()) {
            if (str.charAt(i) < '0' || str.charAt(i) > '9') {
                return 0;
            }
            tmp = str.charAt(i) - '0';
            if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && tmp > 7)) {
                if (sign == 1 || tmp > 8) {
                    return 0;
                }
            }
            res = res * 10 + tmp;
            i++;
        }
        return sign * res;
    }
}
