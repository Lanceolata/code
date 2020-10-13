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

    public void update(int i, int val) {
        i += n;
        tree[i] = val;
        while (i > 0) {
            tree[i / 2] = tree[i] + tree[i ^ 1];
            i /= 2;
        }
    }

    public int sumRange(int i, int j) {
        int sum = 0;
        for (i += n, j += n; i <= j; i /= 2, j /= 2) {
            if ((i & 1) == 1) {
                sum += tree[i++];
            }
            if ((j & 1) == 0) {
                sum += tree[j--];
            }
        }
        return sum;
    }
}
