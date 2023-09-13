package com.lanceolata.coding.algorithms.java.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Question_1019_Next_Greater_Node_In_Linked_List {
    // Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public int[] nextLargerNodes(ListNode head) {
        List<Integer> res = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        ListNode p = head;
        while (p != null) {
            while (!stack.isEmpty() && res.get(stack.peek()) < p.val) {
                res.set(stack.pop(), p.val);
            }
            stack.push(res.size());
            res.add(p.val);
            p = p.next;
        }
        for (int i : stack) {
            res.set(i, 0);
        }
        int[] arr = new int[res.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = res.get(i);
        }
        return arr;
    }
}
