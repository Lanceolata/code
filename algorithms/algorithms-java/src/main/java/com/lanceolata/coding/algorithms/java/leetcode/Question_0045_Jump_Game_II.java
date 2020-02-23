package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0045_Jump_Game_II {
    public int jump(int[] nums) {
        if (nums == null) {
            return -1;
        }
        // 注意记录i的位置，减少重复计算
        int res = 0, i = 0, cur = 0, n = nums.length, pre = 0;
        while (cur < n - 1) {
            res++;
            pre = cur;
            for (; i <= pre; i++) {
                cur = Math.max(cur, i + nums[i]);
            }
            if (cur == pre) {
                return -1;
            }
        }
        return res;
    }
}
