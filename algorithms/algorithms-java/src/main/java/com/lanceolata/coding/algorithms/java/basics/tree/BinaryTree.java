package com.lanceolata.coding.algorithms.java.basics.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTree {
    // Definition for a binary tree node.
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<Integer> preorderTraversalRecursive(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        preorderTraversalRecursive(root, res);
        return res;
    }

    private void preorderTraversalRecursive(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        res.add(root.val);
        preorderTraversalRecursive(root.left, res);
        preorderTraversalRecursive(root.right, res);
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.empty()) {
            if (root != null) {
                res.add(root.val);
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                root = root.right;
            }
        }
        return res;
    }

    public List<Integer> inorderTraversalRecursive(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inorderTraversalRecursive(root, res);
        return res;
    }

    private void inorderTraversalRecursive(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        inorderTraversalRecursive(root.left, res);
        res.add(root.val);
        inorderTraversalRecursive(root.right, res);
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.empty()) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                res.add(root.val);
                root = root.right;
            }
        }
        return res;
    }

    public List<Integer> postorderTraversalRecursive(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        postorderTraversalRecursive(root, res);
        return res;
    }

    private void postorderTraversalRecursive(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        postorderTraversalRecursive(root.left, res);
        postorderTraversalRecursive(root.right, res);
        res.add(root.val);
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        TreeNode last = null;
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.empty()) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                TreeNode node = stack.peek();
                if (node.right != null && node.right != last) {
                    root = node.right;
                } else {
                    stack.pop();
                    res.add(node.val);
                    last = node;
                }
            }
        }
        return res;
    }
}
