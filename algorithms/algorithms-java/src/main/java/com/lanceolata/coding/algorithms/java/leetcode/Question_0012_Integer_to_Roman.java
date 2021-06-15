package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0012_Integer_to_Roman {
    public String intToRoman(int num) {
        int[] aArray = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] rArray = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < rArray.length; i++) {
            while (num >= aArray[i]) {
                num -= aArray[i];
                res.append(rArray[i]);
            }
        }
        return res.toString();
    }
}
