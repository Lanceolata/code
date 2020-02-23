package com.lanceolata.coding.algorithms.java.coding_interviews_2;

public class Question_0022_KthNodeFromEnd {
    // Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode FindKthToTail(ListNode head, int k) {
        if (head == null || k <= 0) {
            return null;
        }
        ListNode p = head;
        while (p != null && k-- > 0) {
            p = p.next;
        }
        if (k > 0) {
            return null;
        }
        while (p != null) {
            head = head.next;
            p = p.next;
        }
        return head;
    }
}
