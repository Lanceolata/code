package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0147_Insertion_Sort_List {
    // Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode(0), p = null, next = null;
        while (head != null) {
            next = head.next;
            p = dummy;
            while (p.next != null && p.next.val < head.val) {
                p = p.next;
            }
            head.next = p.next;
            p.next = head;
            head = next;
        }
        return dummy.next;
    }
}
