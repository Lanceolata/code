package com.lanceolata.coding.algorithms.java.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Question_0863_All_Nodes_Distance_K_in_Binary_Tree {
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

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> res = new ArrayList<>();
        dfs(root, target, k, res);
        return res;
    }

    public int dfs(TreeNode root, TreeNode target, int k, List<Integer> res) {
        if (root == null) {
            return -1;
        } else if (root == target) {
            subtree_add(root, k, 0, res);
            return 1;
        } else {
            int l = dfs(root.left, target, k, res), r = dfs(root.right, target, k, res);
            if (l != -1) {
                if (l == k) {
                    res.add(root.val);
                }
                subtree_add(root.right, k, l + 1, res);
                return l + 1;
            } else if (r != -1) {
                if (r == k) {
                    res.add(root.val);
                }
                subtree_add(root.left, k, r + 1, res);
                return r + 1;
            } else {
                return -1;
            }
        }
    }

    public void subtree_add(TreeNode root, int k, int dist, List<Integer> res) {
        if (root == null) {
            return;
        }
        if (dist == k) {
            res.add(root.val);
        } else {
            subtree_add(root.left, k, dist + 1, res);
            subtree_add(root.right, k, dist + 1, res);
        }
    }
}
