package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0504_Base_7 {
    public String convertToBase7(int num) {
        if (num == 0) {
            return "0";
        }
        StringBuilder res = new StringBuilder();
        String flag = num < 0 ? "-" : "";
        while (num != 0) {
            res.append(Math.abs(num % 7));
            num /= 7;
        }
        return flag + res.reverse().toString();
    }
}
