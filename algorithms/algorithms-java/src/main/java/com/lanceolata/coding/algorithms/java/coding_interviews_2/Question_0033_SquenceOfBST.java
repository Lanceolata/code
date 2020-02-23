package com.lanceolata.coding.algorithms.java.coding_interviews_2;

public class Question_0033_SquenceOfBST {
    // Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public boolean VerifySquenceOfBST(int [] sequence) {
        if (sequence == null || sequence.length <= 0) {
            return false;
        }
        return help(sequence, 0, sequence.length - 1);
    }

    private boolean help(int[] sequence, int l, int h) {
        if (l >= h) {
            return true;
        }
        int root = sequence[h];
        int i = l;
        for (; i < h; i++) {
            if (sequence[i] > root) {
                break;
            }
        }
        for (int j = i; j < h; j++) {
            if (sequence[j] < root) {
                return false;
            }
        }
        return help(sequence, l, i - 1) && help(sequence, i, h - 1);
    }
}
