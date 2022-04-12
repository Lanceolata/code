package com.lanceolata.coding.algorithms.java.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Question_0872_Leaf_Similar_Trees {
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

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> leaves1 = new ArrayList<>(), leaves2 = new ArrayList<>();
        dfs(root1, leaves1);
        dfs(root2, leaves2);
        return leaves1.equals(leaves2);
    }

    public void dfs(TreeNode node, List<Integer> leafValues) {
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null) {
            leafValues.add(node.val);
            return;
        }
        dfs(node.left, leafValues);
        dfs(node.right, leafValues);
    }
}
