package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0091_Decode_Ways {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0 || s.charAt(0) == '0') {
            return 0;
        }
        int num = 1, num1 = 1, num2 = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                if (s.charAt(i - 1) == '1' || s.charAt(i - 1) == '2') {
                    num = num2;
                } else {
                    return 0;
                }
            } else {
                if (s.charAt(i - 1) == '0' || s.charAt(i - 1) >= '3') {
                    num = num1;
                } else {
                    if (s.charAt(i - 1) == '2' && s.charAt(i) >= '7' && s.charAt(i) <= '9') {
                        num = num1;
                    } else {
                        num = num1 + num2;
                    }
                }
            }
            num2 = num1;
            num1 = num;
        }
        return num;
    }
}
