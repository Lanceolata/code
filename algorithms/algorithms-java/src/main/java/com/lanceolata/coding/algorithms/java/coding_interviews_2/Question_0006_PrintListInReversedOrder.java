package com.lanceolata.coding.algorithms.java.coding_interviews_2;

import java.util.ArrayList;

public class Question_0006_PrintListInReversedOrder {
    // Definition for singly-linked list.
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        help(listNode, res);
        return res;
    }

    private void help(ListNode listNode, ArrayList<Integer> res) {
        if (listNode == null) {
            return;
        }
        help(listNode.next, res);
        res.add(listNode.val);
    }
}
