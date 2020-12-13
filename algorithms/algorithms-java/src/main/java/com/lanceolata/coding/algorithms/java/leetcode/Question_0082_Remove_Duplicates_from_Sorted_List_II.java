package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0082_Remove_Duplicates_from_Sorted_List_II {
    // Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p = dummy;
        while (p.next != null) {
            head = p.next;
            while (head.next != null && head.val == head.next.val) {
                head = head.next;
            }
            if (p.next == head) {
                p = p.next;
            } else {
                p.next = head.next;
            }
        }
        return dummy.next;
    }
}
