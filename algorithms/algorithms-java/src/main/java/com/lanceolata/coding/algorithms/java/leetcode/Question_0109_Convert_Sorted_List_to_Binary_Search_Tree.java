package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0109_Convert_Sorted_List_to_Binary_Search_Tree {
    // Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    // Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private ListNode cur = null;

    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        cur = head;
        int len = 0;
        while (head != null) {
            len++;
            head = head.next;
        }
        return help(0, len - 1);
    }

    private TreeNode help(int l, int r) {
        if (l > r) {
            return null;
        }
        int m = l + (r - l) / 2;
        TreeNode left = help(l, m - 1);
        TreeNode root = new TreeNode(cur.val);
        cur = cur.next;
        TreeNode right = help(m + 1, r);
        root.left = left;
        root.right = right;
        return root;
    }
}
