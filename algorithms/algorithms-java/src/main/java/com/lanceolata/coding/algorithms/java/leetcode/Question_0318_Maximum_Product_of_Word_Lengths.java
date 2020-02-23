package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0318_Maximum_Product_of_Word_Lengths {
    public int maxProduct(String[] words) {
        int res = 0;
        int[] masks = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                masks[i] |= 1 << (words[i].charAt(j) - 'a');
            }
            for (int j = 0; j < i; j++) {
                if ((masks[i] & masks[j]) == 0) {
                    res = Math.max(res, words[i].length() * words[j].length());
                }
            }
        }
        return res;
    }
}
