package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0405_Convert_a_Number_to_Hexadecimal {

    private static char[] HEX = {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};

    public String toHex(int num) {
        if (num == 0) {
            return "0";
        }
        String res = "";
        while (num != 0) {
            res = HEX[(num & 0xf)] + res;
            num >>>= 4;
        }
        return res;
    }
}