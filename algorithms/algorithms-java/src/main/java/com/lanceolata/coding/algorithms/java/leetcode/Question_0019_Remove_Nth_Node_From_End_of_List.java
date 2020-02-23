package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0019_Remove_Nth_Node_From_End_of_List {
    // Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || n <= 0) {
            return head;
        }
        ListNode slow = head, fast = head;
        while (fast != null && n-- > 0) {
            fast = fast.next;
        }
        if (n > 0) {
            return null;
        }
        if (fast == null) {
            return head.next;
        }
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return head;
    }
}
