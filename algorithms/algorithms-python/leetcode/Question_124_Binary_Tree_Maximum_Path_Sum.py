#!/usr/bin/python
# coding: utf-8

from TreeNode import *
import sys

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def maxPathSum(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        res = [-sys.maxint - 1]
        self.help(root, res)
        return res[0]
    
    def help(self, root, res):
        if not root:
            return 0
        left = max(self.help(root.left, res), 0)
        right = max(self.help(root.right, res), 0)
        res[0] = max(res[0], left + right + root.val)
        return max(left, right) + root.val
