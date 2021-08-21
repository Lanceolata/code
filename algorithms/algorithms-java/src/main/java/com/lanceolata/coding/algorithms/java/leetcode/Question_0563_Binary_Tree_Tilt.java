package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0563_Binary_Tree_Tilt {
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

    private int res;

    public int findTilt(TreeNode root) {
        res = 0;
        help(root);
        return res;
    }

    private int help(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = help(root.left);
        int right = help(root.right);
        res += Math.abs(left - right);
        return left + right +root.val;
    }
}
