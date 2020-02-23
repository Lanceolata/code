package com.lanceolata.coding.algorithms.java.leetcode;

import java.util.Random;

public class Question_0398_Random_Pick_Index {

    private int[] nums;
    private Random random = new Random();

    public Question_0398_Random_Pick_Index(int[] nums) {
        this.nums = nums;
    }

    public int pick(int target) {
        int cnt = 0, res = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != target) {
                continue;
            }
            cnt++;
            if (random.nextInt(cnt) == 0) {
                res = i;
            }
        }
        return res;
    }
}
