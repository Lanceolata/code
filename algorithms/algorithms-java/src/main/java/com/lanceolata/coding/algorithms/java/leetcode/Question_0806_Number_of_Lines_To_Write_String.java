package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0806_Number_of_Lines_To_Write_String {
    public int[] numberOfLines(int[] widths, String s) {
        int cur = 0;
        int[] res = new int[]{0, 101};
        for (char c : s.toCharArray()) {
            if (cur + widths[c - 'a'] > 100) {
                res[0]++;
                res[1] = Math.min(res[1], cur);
                cur = 0;
            }
            cur += widths[c - 'a'];
        }
        if (cur != 0) {
            res[0]++;
            res[1] = Math.min(res[1], cur);
        }
        return res;
    }
}
