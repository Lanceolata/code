package com.lanceolata.coding.algorithms.java.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Question_0437_Path_Sum_III {
    // Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private int res = 0;

    public int pathSum(TreeNode root, int sum) {
        res = 0;
        if (root == null) {
            return res;
        }
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        help(root, sum, 0, map);
        return res;
    }

    private void help(TreeNode root, int sum, int cur, Map<Integer, Integer> map) {
        if (root == null) {
            return;
        }
        cur += root.val;
        if (map.containsKey(cur - sum)) {
            res += map.get(cur - sum);
        }
        if (map.containsKey(cur)) {
            map.put(cur, map.get(cur) + 1);
        } else {
            map.put(cur, 1);
        }
        help(root.left, sum, cur, map);
        help(root.right, sum, cur, map);
        map.put(cur, map.get(cur) - 1);
    }
}
