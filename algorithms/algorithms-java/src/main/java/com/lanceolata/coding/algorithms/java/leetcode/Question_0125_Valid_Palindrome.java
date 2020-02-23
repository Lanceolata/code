package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0125_Valid_Palindrome {
    public boolean isPalindrome(String s) {
        if (s == null) {
            return false;
        }
        int l = 0, r = s.length() - 1;
        while (l < r) {
            if (!Character.isLetterOrDigit(s.charAt(l))) {
                l++;
            } else if (!Character.isLetterOrDigit(s.charAt(r))) {
                r--;
            } else {
                if (Character.toLowerCase(s.charAt(l++)) != Character.toLowerCase(s.charAt(r--))) {
                    return false;
                }
            }
        }
        return true;
    }
}
