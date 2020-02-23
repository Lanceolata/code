#!/usr/bin/python
# coding: utf-8

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def sumNumbers(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        return self.helper(root, 0)

    def helper(self, root, num):
        if not root:
            return 0
        num = num * 10 + root.val
        if not root.left and not root.right:
            return num
        return self.helper(root.left, num) + self.helper(root.right, num)
