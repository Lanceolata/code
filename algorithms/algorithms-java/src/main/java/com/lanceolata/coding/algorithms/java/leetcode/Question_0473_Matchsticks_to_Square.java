package com.lanceolata.coding.algorithms.java.leetcode;

import java.util.Arrays;
import java.util.Collections;

public class Question_0473_Matchsticks_to_Square {
    public boolean makesquare(int[] matchsticks) {
        if (matchsticks == null || matchsticks.length < 4) {
            return false;
        }
        int sum = 0;
        for (int n : matchsticks) {
            sum += n;
        }
        if (sum % 4 != 0) {
            return false;
        }
        int[] res = new int[4];
        Arrays.sort(matchsticks);
        reverse(matchsticks);
        return help(matchsticks, res, 0, sum / 4);
    }

    private boolean help(int[] nums, int[] sums, int pos, int target) {
        if (pos >= nums.length) {
            return sums[0] == target && sums[1] == target && sums[2] == target;
        }
        for (int i = 0; i < 4; i++) {
            if (sums[i] + nums[pos] > target) {
                continue;
            }
            sums[i] += nums[pos];
            if (help(nums, sums, pos + 1, target)) {
                return true;
            }
            sums[i] -= nums[pos];
        }
        return false;
    }

    private void reverse(int[] nums) {
        int i = 0, j = nums.length - 1;
        while (i < j) {
            int t = nums[i];
            nums[i] = nums[j];
            nums[j] = t;
            i++; j--;
        }
    }
}
