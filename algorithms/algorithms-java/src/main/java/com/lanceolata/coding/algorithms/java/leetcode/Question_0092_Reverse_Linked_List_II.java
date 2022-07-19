package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0092_Reverse_Linked_List_II {
    // Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p = dummy;
        for (int i = 1; i < left; i++) {
            p = p.next;
        }
        ListNode last = p.next, cur;
        for (int i = left; i < right; i++) {
            cur = last.next;
            last.next = cur.next;
            cur.next = p.next;
            p.next = cur;
        }
        return dummy.next;
    }
}
