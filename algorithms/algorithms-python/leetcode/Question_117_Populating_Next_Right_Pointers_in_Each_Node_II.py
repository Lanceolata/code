#!/usr/bin/python
# coding: utf-8

from TreeLinkNode import *

# Definition for binary tree with next pointer.
# class TreeLinkNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None
#         self.next = None

class Solution:
    # @param root, a tree link node
    # @return nothing
    def connect(self, root):
        if not root:
            return
        dummy = TreeLinkNode(0)
        p = dummy
        while root:
            if root.left:
                p.next = root.left
                p = p.next
            
            if root.right:
                p.next = root.right
                p = p.next

            root = root.next
            if not root:
                p = dummy
                root = p.next
                p.next = None
