package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0687_Longest_Univalue_Path {
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

    private int res = 0;

    public int longestUnivaluePath(TreeNode root) {
        res = 0;
        help(root);
        return res;
    }

    public int help(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = help(root.left);
        int right = help(root.right);
        int l = 0, r = 0;
        if (root.left != null && root.left.val == root.val) {
            l += left + 1;
        }
        if (root.right != null && root.right.val == root.val) {
            r += right + 1;
        }
        res = Math.max(res, l + r);
        return Math.max(l, r);
    }
}
