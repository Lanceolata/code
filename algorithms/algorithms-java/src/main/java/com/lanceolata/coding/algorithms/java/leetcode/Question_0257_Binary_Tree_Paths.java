package com.lanceolata.coding.algorithms.java.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Question_0257_Binary_Tree_Paths {
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

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        dfs(root, "", res);
        return res;
    }

    private void dfs(TreeNode root, String str, List<String> res) {
        if (root.left == null && root.right == null) {
            res.add(str + root.val);
        }
        if (root.left != null) {
            dfs(root.left, str + root.val + "->", res);
        }
        if (root.right != null) {
            dfs(root.right, str + root.val + "->", res);
        }
    }
}
