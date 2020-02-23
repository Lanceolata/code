#!/usr/bin/python
# coding: utf-8

from TreeNode import *
import sys

class Solution(object):
    def getMinimumDifference(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        res = [sys.maxint]
        pre = [-1]
        self.inorder(root, pre, res)
        return res[0]

    def inorder(self, root, pre, res):
        if not root:
            return
        self.inorder(root.left, pre, res)
        if pre[0] != -1:
            res[0] = min(res[0], root.val - pre[0])
        pre[0] = root.val
        self.inorder(root.right, pre, res)
