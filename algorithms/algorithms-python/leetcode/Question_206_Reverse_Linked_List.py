#!/usr/bin/python
# coding: utf-8

from ListNode import *

class Solution(object):
    def reverseList(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """
        pre, cur, next = None, head, None
        while cur:
            next = cur.next
            cur.next = pre
            pre = cur
            cur = next
        return pre


head = ListNode(1)
head.next = ListNode(2)
head.next.next = ListNode(3)
head.next.next.next = ListNode(4)

sol = Solution()
res = sol.reverseList(head)
ListNode.printNode(res)
