#!/usr/bin/python
# coding: utf-8

from TreeNode import *

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def flatten(self, root):
        """
        :type root: TreeNode
        :rtype: void Do not return anything, modify root in-place instead.
        """
        while root:
            if root.left:
                tmp = root.left
                while tmp.right:
                    tmp = tmp.right
                tmp.right = root.right
                root.right = root.left
                root.left = None
            root = root.right
