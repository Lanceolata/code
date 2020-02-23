package com.lanceolata.coding.algorithms.java.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Question_0093_Restore_IP_Addresses {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        if (s == null) {
            return res;
        }
        for (int i = 1; i < 4; i++) {
            for (int j = 1; j < 4; j++) {
                for (int k = 1; k < 4; k++) {
                    for (int l = 1; l < 4; l++) {
                        if (i + j + k + l == s.length()) {
                            int num1 = Integer.parseInt(s.substring(0, i));
                            int num2 = Integer.parseInt(s.substring(i, i + j));
                            int num3 = Integer.parseInt(s.substring(i + j, i + j + k));
                            int num4 = Integer.parseInt(s.substring(i + j + k, i + j + k + l));
                            if (num1 <= 255 && num2 <= 255 && num3 <= 255 && num4 <= 255) {
                                String tmp = num1 + "." + num2 + "." + num3 + "." + num4;
                                // 防止有0开头的数字，需要判断长度
                                if (tmp.length() == s.length() + 3) {
                                    res.add(tmp);
                                }
                            }
                        }
                    }
                }
            }
        }
        return res;
    }
}
