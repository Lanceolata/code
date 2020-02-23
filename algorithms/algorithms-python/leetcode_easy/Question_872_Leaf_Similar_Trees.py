#!/usr/bin/python
# coding: utf-8

from TreeNode import *

class Solution(object):
    def leafSimilar(self, root1, root2):
        """
        :type root1: TreeNode
        :type root2: TreeNode
        :rtype: bool
        """
        def help(node, vec):
            if not node:
                return
            if node.left or node.right:
                help(node.left, vec)
                help(node.right, vec)
            else:
                vec.append(node.val)

        vec1, vec2 = [], []
        help(root1, vec1)
        help(root2, vec2)
        return vec1 == vec2