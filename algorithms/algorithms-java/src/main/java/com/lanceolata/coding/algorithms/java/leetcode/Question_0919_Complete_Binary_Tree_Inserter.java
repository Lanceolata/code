package com.lanceolata.coding.algorithms.java.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Question_0919_Complete_Binary_Tree_Inserter {
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

    private List<TreeNode> tree;

    public Question_0919_Complete_Binary_Tree_Inserter(TreeNode root) {
        tree = new ArrayList<>();
        tree.add(root);
        for (int i = 0; i < tree.size(); ++i) {
            if (tree.get(i).left != null) {
                tree.add(tree.get(i).left);
            }
            if (tree.get(i).right != null) {
                tree.add(tree.get(i).right);
            }
        }
    }

    public int insert(int val) {
        int n = tree.size();
        TreeNode node = new TreeNode(val);
        tree.add(node);
        if (n % 2 == 1) {
            tree.get((n - 1) / 2).left = node;
        } else {
            tree.get((n - 1) / 2).right = node;
        }
        return tree.get((n - 1) / 2).val;
    }

    public TreeNode get_root() {
        return tree.get(0);
    }
}
