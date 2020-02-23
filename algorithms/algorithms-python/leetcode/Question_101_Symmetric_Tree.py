#!/usr/bin/python
# coding: utf-8

# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution(object):
    def isSymmetric(self, root):
        """
        :type root: TreeNode
        :rtype: bool
        """
        return self.isMirrot(root, root)

    def isMirrot(self, t1, t2):
        if not t1 or not t2:
            return t1 is t2
        return t1.val == t2.val and self.isMirrot(t1.left, t2.right) \
            and self.isMirrot(t1.right, t2.left)
