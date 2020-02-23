#!/usr/bin/python
# coding: utf-8

from TreeNode import *

class Solution(object):
    def diameterOfBinaryTree(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        res = [0]
        self.depth(root, res)
        return res[0]

    def depth(self, root, res):
        if not root:
            return 0
        l = self.depth(root.left, res)
        r = self.depth(root.right, res)
        res[0] = max(res[0], l + r)
        return max(l, r) + 1
    
