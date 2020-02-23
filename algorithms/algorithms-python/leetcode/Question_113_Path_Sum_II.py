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
    def pathSum(self, root, sum):
        """
        :type root: TreeNode
        :type sum: int
        :rtype: List[List[int]]
        """
        if not root:
            return []
        res, vec = [], []
        self.helper(root, sum, vec, res)
        return res

    def helper(self, root, num, vec, res):
        if not root:
            return
        vec.append(root.val)
        if not root.left and not root.right and root.val == num:
            res.append(vec[:])
        self.helper(root.left, num-root.val, vec, res)
        self.helper(root.right, num-root.val, vec, res)
        vec.pop()
