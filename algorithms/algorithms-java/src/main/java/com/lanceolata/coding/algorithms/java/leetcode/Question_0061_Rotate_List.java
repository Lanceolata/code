package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0061_Rotate_List {
    // Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k <= 0) {
            return head;
        }
        ListNode p = head;
        int n = 1;
        while (p.next != null) {
            n++;
            p = p.next;
        }
        p.next = head;
        n = n - k % n;
        while (n-- > 0) {
            p = p.next;
        }
        head = p.next;
        p.next = null;
        return head;
    }
}
