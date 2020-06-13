package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0383_Ransom_Note {
    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote == null || magazine == null || ransomNote.length() > magazine.length()) {
            return false;
        }
        int[] index = new int[256];
        for (int i = 0; i < magazine.length(); i++) {
            index[magazine.charAt(i)]++;
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            if (index[ransomNote.charAt(i)]-- <= 0) {
                return false;
            }
        }
        return true;
    }
}
