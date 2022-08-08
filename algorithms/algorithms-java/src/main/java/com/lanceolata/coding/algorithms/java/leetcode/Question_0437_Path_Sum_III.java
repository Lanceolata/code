package com.lanceolata.coding.algorithms.java.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Question_0437_Path_Sum_III {
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

    private int res = 0;

    public int pathSum(TreeNode root, int targetSum) {
        res = 0;
        if (root == null) {
            return res;
        }
        Map<Long, Integer> map = new HashMap<>();
        map.put(0L, 1);
        help(root, targetSum, 0, map);
        return res;
    }

    private void help(TreeNode root, int targetSum, long cur, Map<Long, Integer> map) {
        if (root == null) {
            return;
        }
        cur += root.val;
        if (map.containsKey(cur - targetSum)) {
            res += map.get(cur - targetSum);
        }
        if (map.containsKey(cur)) {
            map.put(cur, map.get(cur) + 1);
        } else {
            map.put(cur, 1);
        }
        help(root.left, targetSum, cur, map);
        help(root.right, targetSum, cur, map);
        map.put(cur, map.get(cur) - 1);
    }
}
