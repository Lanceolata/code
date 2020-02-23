#!/usr/bin/python
# coding: utf-8

# Definition for singly-linked list.
class ListNode(object):
    def __init__(self, x):
        self.val = x
        self.next = None


class Solution(object):
    def deleteDuplicates(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """
        if not head or not head.next:
            return head
        node = ListNode(0)
        node.next = head
        pre = node
        while pre.next:
            cur = pre.next
            while cur.next and cur.val == cur.next.val:
                cur = cur.next
            if cur != pre.next:
                pre.next = cur.next
            else:
                pre = pre.next
        return node.next
