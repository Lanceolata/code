package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0993_Cousins_in_Binary_Tree {
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

    public boolean isCousins(TreeNode root, int x, int y) {
        if (checkSameParent(root, x, y)) {
            return false;
        }
        return getDepth(root, x, 0) == getDepth(root, y, 0);
    }

    private boolean checkSameParent(TreeNode root, int x, int y) {
        if (root == null) {
            return false;
        }
        if (root.left != null && root.right != null
                && ((root.left.val == x && root.right.val == y) || (root.left.val == y && root.right.val == x))) {
            return true;
        }
        return checkSameParent(root.left, x, y) || checkSameParent(root.right, x, y);
    }

    private int getDepth(TreeNode root, int v, int d) {
        if (root == null) {
            return -1;
        }
        if (root.val == v) {
            return d;
        }
        return Math.max(getDepth(root.left, v, d + 1), getDepth(root.right, v, d + 1));
    }
}
