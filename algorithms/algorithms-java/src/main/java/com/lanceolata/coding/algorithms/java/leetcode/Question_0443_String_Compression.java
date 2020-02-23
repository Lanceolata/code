package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0443_String_Compression {
    public int compress(char[] chars) {
        int i = 0, cnt = 1;
        for (int j = 0; j < chars.length; j++) {
            if (j + 1 < chars.length && chars[j] == chars[j + 1]) {
                cnt++;
            } else {
                chars[i++] = chars[j];
                if (cnt > 1) {
                    String count = "" + cnt;
                    for (int k = 0; k < count.length(); k++) {
                        chars[i++] = count.charAt(k);
                    }
                }
                cnt = 1;
            }
        }
        return i;
    }
}
