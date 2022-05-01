package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0925_Long_Pressed_Name {
    public boolean isLongPressedName(String name, String typed) {
        if (typed.length() < name.length()) {
            return false;
        }
        int i = 0, j = 0;
        while (i < name.length() && j < typed.length()) {
            if (name.charAt(i) == typed.charAt(j)) {
                i++;
                j++;
            } else if (j > 0 && typed.charAt(j) == typed.charAt(j - 1)) {
                j++;
            } else {
                return false;
            }
        }
        while (j < typed.length() && j > 0 && typed.charAt(j) == typed.charAt(j - 1)) {
            j++;
        }
        return i == name.length() && j == typed.length();
    }
}
