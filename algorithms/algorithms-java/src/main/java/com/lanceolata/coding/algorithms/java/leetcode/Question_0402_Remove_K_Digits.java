package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0402_Remove_K_Digits {
    public String removeKdigits(String num, int k) {
        StringBuilder res = new StringBuilder();
        int n = num.length(), keep = n - k;
        for (int i = 0; i < num.length(); i++) {
            char c = num.charAt(i);
            while (k > 0 && res.length() > 0 && res.charAt(res.length() - 1) > c) {
                res.deleteCharAt(res.length() - 1);
                k--;
            }
            if (res.length() > 0 || c != '0') {
                res.append(c);
            }
        }
        while (res.length() > 0 && k-- > 0) {
            res.deleteCharAt(res.length() - 1);
        }
        return res.length() == 0 ? "0" : res.toString();
    }
}
