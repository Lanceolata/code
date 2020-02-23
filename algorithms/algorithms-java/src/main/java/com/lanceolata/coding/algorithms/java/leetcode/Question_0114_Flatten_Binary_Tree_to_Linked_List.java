package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0114_Flatten_Binary_Tree_to_Linked_List {
    // Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public void flatten(TreeNode root) {
        TreeNode p;
        while (root != null) {
            if (root.left != null) {
                p = root.left;
                while (p.right != null) {
                    p = p.right;
                }
                p.right = root.right;
                root.right = root.left;
                root.left = null;
            }
            root = root.right;
        }
    }
}
