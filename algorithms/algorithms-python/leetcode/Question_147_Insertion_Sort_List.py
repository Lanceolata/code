#!/usr/bin/python
# coding: utf-8

# Definition for singly-linked list.
class ListNode(object):
    def __init__(self, x):
        self.val = x
        self.next = None


class Solution(object):
    def insertionSortList(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """
        if not head or not head.next:
            return head
        dummy = ListNode(0)
        pre, cur, next = dummy, head, None
        while cur:
            next = cur.next
            pre = dummy
            while pre.next and pre.next.val <= cur.val:
                pre = pre.next
            cur.next = pre.next
            pre.next = cur
            cur = next
        return dummy.next
