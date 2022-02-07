package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0654_Maximum_Binary_Tree {
    // Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        return help(nums, 0, nums.length - 1);
    }

    private TreeNode help(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        if (start == end) {
            return new TreeNode(nums[start]);
        }
        int i = start;
        for (int j = start; j <= end; j++) {
            if (nums[j] > nums[i]) {
                i = j;
            }
        }
        TreeNode root = new TreeNode(nums[i]);
        root.left = help(nums, start, i - 1);
        root.right = help(nums, i + 1, end);
        return root;
    }
}
