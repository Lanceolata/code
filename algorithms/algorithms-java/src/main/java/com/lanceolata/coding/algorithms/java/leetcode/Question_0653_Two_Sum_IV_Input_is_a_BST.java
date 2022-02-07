package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0653_Two_Sum_IV_Input_is_a_BST {
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

    public boolean findTarget(TreeNode root, int k) {
        return dfs(root, root, k);
    }

    private boolean dfs(TreeNode cur, TreeNode root, int k) {
        if (cur == null) {
            return false;
        }
        return search(cur, root, k - cur.val) || dfs(cur.left, root, k) || dfs(cur.right, root, k);
    }

    private boolean search(TreeNode cur, TreeNode root, int k) {
        if (root == null) {
            return false;
        }
        if (root.val == k && cur != root) {
            return true;
        }
        if (root.val < k) {
            return search(cur, root.right, k);
        } else {
            return search(cur, root.left, k);
        }
    }
}
