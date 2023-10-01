package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_1026_Maximum_Difference_Between_Node_and_Ancestor {
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

    public int maxAncestorDiff(TreeNode root) {
        if (root == null) {
            return -1;
        }
        res = 0;
        help(root, root.val, root.val);
        return res;
    }

    private void help(TreeNode root, int pmax, int pmin) {
        if (root == null) {
            return;
        }
        res = Math.max(res, Math.abs(root.val - pmax));
        res = Math.max(res, Math.abs(root.val - pmin));
        pmax = Math.max(pmax, root.val);
        pmin = Math.min(pmin, root.val);
        help(root.left, pmax, pmin);
        help(root.right, pmax, pmin);
    }
}
