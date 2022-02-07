package com.lanceolata.coding.algorithms.java.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Question_0652_Find_Duplicate_Subtrees {
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

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Map<String, List<TreeNode>> map = new HashMap<>();
        serialize(root, map);
        for (Map.Entry<String, List<TreeNode>> entry : map.entrySet()) {
            if (entry.getValue().size() > 1) {
                res.add(entry.getValue().get(0));
            }
        }
        return res;
    }

    private String serialize(TreeNode root, Map<String, List<TreeNode>> map) {
        if (root == null) {
            return "";
        }
        String s = root.val + "(" + serialize(root.left, map) + "," + serialize(root.right, map) + ")";
        if (!map.containsKey(s)) {
            map.put(s, new ArrayList<>());
        }
        map.get(s).add(root);
        return s;
    }
}
