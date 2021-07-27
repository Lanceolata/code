package com.lanceolata.coding.algorithm.java.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Question_0501_Find_Mode_in_Binary_Search_Tree {
    // Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int[] findMode(TreeNode root) {
        if (root == null) {
            return new int[0];
        }
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;
        int cnt = 1, max = 0;
        while (root != null || !stack.isEmpty()) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                if (pre != null) {
                    cnt = (pre.val == root.val) ? cnt + 1 : 1;
                }
                if (cnt >= max) {
                    if (cnt > max) {
                        list.clear();
                    }
                    list.add(root.val);
                    max = cnt;
                }
                pre = root;
                root = root.right;
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}
