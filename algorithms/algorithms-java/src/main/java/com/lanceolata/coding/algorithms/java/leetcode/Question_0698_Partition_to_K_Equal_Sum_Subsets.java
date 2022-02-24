package com.lanceolata.coding.algorithms.java.leetcode;

import java.util.Arrays;

public class Question_0698_Partition_to_K_Equal_Sum_Subsets {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for (int n : nums) {
            sum += n;
        }
        if (sum % k != 0) {
            return false;
        }
        boolean[] visited = new boolean[nums.length];
        Arrays.sort(nums);
        return help(nums, k, sum / k, 0, 0, visited);
    }

    private boolean help(int[] nums, int k, int target, int cur, int index, boolean[] visited) {
        if (k == 1) {
            return true;
        }
        if (cur == target) {
            return help(nums, k - 1, target, 0, 0, visited);
        }
        for (int i = index; i < nums.length; i++) {
            if (visited[i] || nums[i] + cur > target) {
                continue;
            }
            visited[i] = true;
            if (help(nums, k, target, cur + nums[i], i + 1, visited)) {
                return true;
            }
            visited[i] = false;
            while (i + 1 < nums.length && nums[i] == nums[i + 1]) {
                i++;
            }
        }
        return false;
    }
}
