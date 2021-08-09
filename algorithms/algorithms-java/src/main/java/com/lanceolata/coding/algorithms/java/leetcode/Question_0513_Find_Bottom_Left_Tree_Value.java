package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0513_Find_Bottom_Left_Tree_Value {
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

    public int findBottomLeftValue(TreeNode root) {
        if (root == null) {
            return -1;
        }
        int[] res = help(root);
        return res[0];
    }

    private int[] help(TreeNode root) {
        if (root == null) {
            return null;
        }
        int[] left = help(root.left);
        int[] right = help(root.right);
        int[] res = new int[] {root.val, 1};
        if (left != null) {
            res[0] = left[0];
            res[1] = left[1] + 1;
        }
        if (right != null && (left == null || left[1] < right[1])) {
            res[0] = right[0];
            res[1] = right[1] + 1;
        }
        return res;
    }
}
