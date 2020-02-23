package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0148_Sort_List {
    // Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode sortList(ListNode head) {
        // 注意判断head.next == null
        // 否则会stackoverflow
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = head, fast = head;
        // 注意判断条件
        // 使用fast ！= nulll && fast.next != null 会出现stackoverflow
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        fast = slow.next;
        slow.next = null;
        return merge(sortList(head), sortList(fast));
    }

    private ListNode merge(ListNode h1, ListNode h2) {
        ListNode dummy = new ListNode(0);
        ListNode p = dummy;
        while (h1 != null && h2 != null) {
            if (h1.val < h2.val) {
                p.next = h1;
                h1 = h1.next;
            } else {
                p.next = h2;
                h2 = h2.next;
            }
            p = p.next;
        }
        p.next = (h1 != null) ? h1 : h2;
        return dummy.next;
    }
}
