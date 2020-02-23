#!/usr/bin/python
# coding: utf-8

from ListNode import *
from TreeNode import *

# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def init(self):
        self.cur = None

    def sortedListToBST(self, head):
        """
        :type head: ListNode
        :rtype: TreeNode
        """
        if not head:
            return None
        self.cur = head
        num = 0
        while head:
            num += 1
            head = head.next
        return self.build(0, num - 1)

    def build(self, l, r):
        if l > r:
            return None
        mid = l + (r - l) / 2
        left = self.build(l, mid - 1)
        root = TreeNode(self.cur.val)
        root.left = left
        self.cur = self.cur.next
        root.right = self.build(mid + 1, r)
        return root
