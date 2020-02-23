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
        for (int i = n, j = 0; i < 2 * n; i++, j++) {
            tree[i] = nums[j];
        }
        for (int i = n - 1; i > 0; i--) {
            tree[i] = tree[i * 2] + tree[i * 2 + 1];
        }
    }

    public void update(int i, int val) {
        i += n;
        tree[i] = val;
        while (i > 0) {
            int left = i;
            int right = i;
            if (i % 2 == 0) {
                right = i + 1;
            } else {
                left = i - 1;
            }
            // parent is updated after child is updated
            tree[i / 2] = tree[left] + tree[right];
            i /= 2;
        }
    }

    public int sumRange(int i, int j) {
        // get leaf with value 'i'
        i += n;
        // get leaf with value 'j'
        j += n;
        int sum = 0;
        while (i <= j) {
            if ((i % 2) == 1) {
                sum += tree[i];
                i++;
            }
            if ((j % 2) == 0) {
                sum += tree[j];
                j--;
            }
            i /= 2;
            j /= 2;
        }
        return sum;
    }
}
