#!/usr/bin/python
# coding: utf-8

# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution(object):
    def __init__(self):
        self.pre = None

    def isValidBST(self, root):
        """
        :type root: TreeNode
        :rtype: bool
        """
        if root:
            if not self.isValidBST(root.left):
                return False
            if self.pre and root.val <= self.pre.val:
                return False
            self.pre = root
            return self.isValidBST(root.right)
        return True
