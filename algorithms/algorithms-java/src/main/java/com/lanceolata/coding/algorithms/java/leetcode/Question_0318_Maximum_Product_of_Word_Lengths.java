package com.lanceolata.coding.algorithms.java.leetcode;

import java.util.Arrays;

public class Question_0318_Maximum_Product_of_Word_Lengths {
    public int maxProduct(String[] words) {
        int res = 0;
        if (words == null || words.length == 0) {
            return res;
        }
        int[] masks = new int[words.length];
        Arrays.fill(masks, 0);
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                masks[i] |= 1 << (words[i].charAt(j) - 'a');
            }
        }
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if ((masks[i] & masks[j]) == 0) {
                    res = Math.max(res, words[i].length() * words[j].length());
                }
            }
        }
        return res;
    }
}
