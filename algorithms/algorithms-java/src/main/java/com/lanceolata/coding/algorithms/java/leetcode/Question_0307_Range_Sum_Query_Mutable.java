package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0307_Range_Sum_Query_Mutable {
    private int[] tree;
    private int n;

    public Question_0307_Range_Sum_Query_Mutable(int[] nums) {
        if (nums != null && nums.length > 0) {
            n = nums.length;
            tree = new int[n * 2];
            buildTree(nums);
        }
    }

    private void buildTree(int[] nums) {
        for (int i = n; i < 2 * n; i++) {
            tree[i] = nums[i - n];
        }
        for (int i = n - 1; i > 0; i--) {
            tree[i] = tree[i * 2] + tree[i * 2 + 1];
        }
    }

    public void update(int index, int val) {
        index += n;
        tree[index] = val;
        while (index > 0) {
            tree[index / 2] = tree[index] + tree[index ^ 1];
            index /= 2;
        }
    }

    public int sumRange(int left, int right) {
        int sum = 0;
        for (left += n, right += n; left <= right; left /= 2, right /= 2) {
            if ((left & 1) == 1) {
                sum += tree[left++];
            }
            if ((right & 1) == 0) {
                sum += tree[right--];
            }
        }
        return sum;
    }
}
