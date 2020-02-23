#!/usr/bin/python
# coding: utf-8

# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution(object):
    def inorderTraversal(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """
        res = []
        cur = root
        while cur:
            if not cur.left:
                res.append(cur.val)
                cur = cur.right
            else:
                p = cur.left;
                while p.right != cur and p.right:
                    p = p.right
                if not p.right:
                    p.right = cur
                    cur = cur.left
                else:
                    p.right = None
                    res.append(cur.val)
                    cur = cur.right
        return res
