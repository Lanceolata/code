#!/usr/bin/python
# coding: utf-8

# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution(object):
    def postorderTraversal(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """
        if not root:
            return []
        res, stack, last = [], [], None
        while root or stack:
            if root:
                stack.append(root)
                root = root.left
            else:
                n = stack[-1]
                if n.right and n.right != last:
                    root = n.right
                else:
                    res.append(n.val)
                    last = n
                    stack.pop()
        return res
