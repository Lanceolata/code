package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_1047_Remove_All_Adjacent_Duplicates_In_String {
    public String removeDuplicates(String s) {
        int i = 0, n = s.length();
        char[] res = s.toCharArray();
        for (int j = 0; j < n; ++j, ++i) {
            res[i] = res[j];
            if (i > 0 && res[i - 1] == res[i]) {
                System.out.println(i);
                i -= 2;
            }
        }
        return new String(res, 0, i);
    }
}
