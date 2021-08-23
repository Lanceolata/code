package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0565_Array_Nesting {
    public int arrayNesting(int[] nums) {
        int n = nums.length, res = 0;
        for (int i = 0; i < n; i++) {
            int cnt = 0, cur = i, next;
            while (nums[cur] != n) {
                cnt++;
                next = nums[cur];
                nums[cur] = n;
                cur = next;
            }
            res = Math.max(res, cnt);
        }
        return res;
    }
}
