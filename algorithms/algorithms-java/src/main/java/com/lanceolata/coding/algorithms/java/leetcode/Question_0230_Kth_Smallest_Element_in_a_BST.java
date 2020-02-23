package com.lanceolata.coding.algorithms.java.leetcode;

import java.util.Stack;

public class Question_0230_Kth_Smallest_Element_in_a_BST {
    // Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private int i = 0;

    public int kthSmallestRecursive(TreeNode root, int k) {
        i = 0;
        Integer res = help(root, k);
        return res == null ? 0 : res;
    }

    private Integer help(TreeNode root, int k) {
        if (root == null) {
            return null;
        }
        Integer res = help(root.left, k);
        if (res != null) {
            return res;
        }
        if (++i == k) {
            return root.val;
        }
        return help(root.right, k);
    }

    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        int i = 0;
        while (root != null || !stack.isEmpty()) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                if (++i == k) {
                    return root.val;
                }
                root = root.right;
            }
        }
        return 0;
    }
}
