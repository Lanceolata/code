#!/usr/bin/python
# coding: utf-8

from ListNode import *

class Solution(object):
    def isPalindrome(self, head):
        """
        :type head: ListNode
        :rtype: bool
        """
        slow, fast = head, head
        while fast and fast.next:
            fast = fast.next.next
            slow = slow.next
        if fast:
            slow = slow.next
        slow = self.reverse(slow)
        fast = head
        while slow:
            if slow.val != fast.val:
                return False
            fast = fast.next
            slow = slow.next
        return True


    def reverse(self, head):
        pre, next = None, None
        while head:
            next = head.next
            head.next = pre
            pre = head
            head = next
        return pre

head = ListNode(1)
sol = Solution()
print sol.isPalindrome(head)
head.next = ListNode(2)
print sol.isPalindrome(head)
