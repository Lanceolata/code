#!/usr/bin/python
# coding: utf-8

# Definition for singly-linked list.
class ListNode(object):
    def __init__(self, x):
        self.val = x
        self.next = None


class Solution(object):
    def swapPairs(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """
        if not head:
            return head
        help = ListNode(0)
        help.next = head
        pre, cur, next = help, head, None
        while cur and cur.next:
            next = cur.next.next
            pre.next = cur.next
            cur.next.next = cur
            cur.next = next
            pre = cur
            cur = next
        return help.next
