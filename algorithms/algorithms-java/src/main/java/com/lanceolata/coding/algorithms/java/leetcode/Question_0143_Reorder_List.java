package com.lanceolata.coding.algorithms.java.leetcode;

public class Question_0143_Reorder_List {
    // Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        // 快慢指针找到中间节点
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // 拆分链表为两部分
        fast = reverse(slow.next);
        slow.next = null;
        // 合并链表
        merge(head, fast);
    }

    private ListNode reverse(ListNode head) {
        ListNode pre = null, next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    private void merge(ListNode head1, ListNode head2) {
        ListNode p = head1, q = head2, temp;
        while (p != null && q != null) {
            temp = p.next;
            p.next = q;
            p = temp;
            temp = q.next;
            q.next = p;
            q = temp;
        }
    }
}
