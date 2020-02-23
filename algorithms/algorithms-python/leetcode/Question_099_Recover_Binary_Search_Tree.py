#!/usr/bin/python
# coding: utf-8

import sys


# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution(object):
    def recoverTree(self, root):
        """
        :type root: TreeNode
        :rtype: void Do not return anything, modify root in-place instead.
        """
        ps = [None, None, TreeNode(-sys.maxint-1)]
        self.inorder(root, ps)
        tmp = ps[0].val
        ps[0].val = ps[1].val
        ps[1].val = tmp

    def inorder(self, root, ps):
        if not root:
            return
        self.inorder(root.left, ps)
        if ps[2].val >= root.val:
            if not ps[0]:
                ps[0] = ps[2]
            ps[1] = root
        ps[2] = root
        self.inorder(root.right, ps)