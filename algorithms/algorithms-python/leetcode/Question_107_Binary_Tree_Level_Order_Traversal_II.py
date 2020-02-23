#!/usr/bin/python
# coding: utf-8

import Queue


# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution(object):
    def levelOrderBottom(self, root):
        """
        :type root: TreeNode
        :rtype: List[List[int]]
        """
        if not root:
            return None
        q = Queue.Queue()
        res = []
        q.put(root)
        while not q.empty():
            size = q.qsize()
            vec = []
            while size > 0:
                size -= 1
                node = q.get()
                vec.append(node.val)
                if node.left:
                    q.put(node.left)
                if node.right:
                    q.put(node.right)
            res.append(vec)
        return res[::-1]
