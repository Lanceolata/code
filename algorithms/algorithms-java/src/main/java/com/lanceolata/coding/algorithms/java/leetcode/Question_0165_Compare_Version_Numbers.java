package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0165_Compare_Version_Numbers {
    public int compareVersion(String version1, String version2) {
        if (version1 == null || version2 == null) {
            return 0;
        }
        String[] strs1 = version1.split("\\."), strs2 = version2.split("\\.");
        int i = 0, m = strs1.length, n = strs2.length;
        while (i < m || i < n) {
            int num1 = (i < m) ? Integer.parseInt(strs1[i]) : 0;
            int num2 = (i < n) ? Integer.parseInt(strs2[i]) : 0;
            if (num1 < num2) {
                return -1;
            } else if (num1 > num2) {
                return 1;
            } else {
                i++;
            }
        }
        return 0;
    }
}
