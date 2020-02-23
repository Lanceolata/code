package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0260_Single_Number_III {
    public int[] singleNumber(int[] nums) {
        int diff = 0;
        for (int n : nums) {
            diff ^= n;
        }
        int[] res = new int[2];
        // 获得为1的最低一位
        diff = diff & (~(diff - 1));
        for (int n : nums) {
            if ((n & diff) == 0) {
                res[0] ^= n;
            } else {
                res[1] ^= n;
            }
        }
        return res;
    }
}
