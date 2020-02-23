package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0345_Reverse_Vowels_of_a_String {
    public String reverseVowels(String s) {
        if(s == null || s.length() == 0) {
            return s;
        }
        char[] chars = s.toCharArray();
        int l = 0, r = s.length() - 1;
        while (l < r) {
            while (l < r && !isVowel(chars[l])) {
                l++;
            }
            while (l < r && !isVowel(chars[r])) {
                r--;
            }
            char temp = chars[l];
            chars[l] = chars[r];
            chars[r] = temp;
            l++; r--;
        }
        return new String(chars);
    }

    private boolean isVowel(char c) {
        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' ||
                c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U') {
            return true;
        } else {
            return false;
        }
    }
}
