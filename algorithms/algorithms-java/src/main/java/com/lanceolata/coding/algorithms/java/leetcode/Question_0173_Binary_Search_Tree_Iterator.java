package com.lanceolata.coding.algorithms.java.leetcode;

import java.util.Stack;

public class Question_0173_Binary_Search_Tree_Iterator {
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

    private Stack<TreeNode> stack;

    public Question_0173_Binary_Search_Tree_Iterator(TreeNode root) {
        stack = new Stack<>();
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode p = stack.pop();
        int res = p.val;
        p = p.right;
        while (p != null) {
            stack.push(p);
            p = p.left;
        }
        return res;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.empty();
    }
}
