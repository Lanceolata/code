package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0777_Swap_Adjacent_in_LR_String {
    public boolean canTransform(String start, String result) {
        if (!start.replace("X", "").equals(result.replace("X", ""))) {
            return false;
        }
        int n = start.length();
        for (int i = 0, j = 0; i < n && j < n;) {
            if (start.charAt(i) == 'X') {
                i++;
            } else if (result.charAt(j) == 'X') {
                j++;
            } else {
                if ((start.charAt(i) == 'L' && i < j) || (start.charAt(i) == 'R' && i > j)) {
                    return false;
                }
                i++;
                j++;
            }
        }
        return true;
    }
}
