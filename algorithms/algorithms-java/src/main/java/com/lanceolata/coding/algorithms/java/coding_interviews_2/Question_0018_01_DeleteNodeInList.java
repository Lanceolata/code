package com.lanceolata.coding.algorithms.java.coding_interviews_2;

public class Question_0018_01_DeleteNodeInList {
    // Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    ListNode DeleteNode(ListNode head, ListNode delete) {
        if (head == null || delete == null) {
            return head;
        }
        if (delete.next != null) {
            delete.val = delete.next.val;
            delete.next = delete.next.next;
            return head;
        } else if (head == delete) {
            return null;
        } else {
            ListNode p = head;
            while (p != null && p.next != delete) {
                p = p.next;
            }
            if (p != null) {
                p.next = null;
            }
            return head;
        }
    }
}
