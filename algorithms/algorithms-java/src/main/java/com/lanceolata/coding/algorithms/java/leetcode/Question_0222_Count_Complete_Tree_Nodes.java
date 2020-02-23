package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0222_Count_Complete_Tree_Nodes {
    // Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int countNodes(TreeNode root) {
        int left = leftHeight(root);
        int right = rightHeight(root);
        if (left == right) {
            return (int) Math.pow(2, left) - 1;
        }
        return countNodes(root.left) + countNodes(root.right) + 1;
    }

    private int leftHeight(TreeNode root) {
        int res = 0;
        while (root != null) {
            res++;
            root = root.left;
        }
        return res;
    }

    private int rightHeight(TreeNode root) {
        int res = 0;
        while (root != null) {
            res++;
            root = root.right;
        }
        return res;
    }
}
