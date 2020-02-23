package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0038_Count_and_Say {
    public String countAndSay(int n) {
        if (n <= 0) {
            return "";
        }
        String res = "1";
        while (--n > 0) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < res.length(); i++) {
                int cnt = 1;
                while (i + 1 < res.length() && res.charAt(i) == res.charAt(i + 1)) {
                    i++;
                    cnt++;
                }
                sb.append(cnt).append(res.charAt(i));
            }
            res = sb.toString();
        }
        return res;
    }
}
