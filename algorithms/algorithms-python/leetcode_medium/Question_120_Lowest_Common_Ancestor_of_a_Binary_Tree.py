#!/usr/bin/python
# coding: utf-8

from TreeNode import *

class Solution(object):
    def lowestCommonAncestor(self, root, p, q):
        """
        :type root: TreeNode
        :type p: TreeNode
        :type q: TreeNode
        :rtype: TreeNode
        """
        if not root or root == p or root == q:
            return root
        left = self.lowestCommonAncestor(root.left, p, q)
        if left and left != p and left != q:
            return left
        right = self.lowestCommonAncestor(root.right, p, q)
        if right and right != p and right != q:
            return right
        if left and right:
            return root
        return left if left else right