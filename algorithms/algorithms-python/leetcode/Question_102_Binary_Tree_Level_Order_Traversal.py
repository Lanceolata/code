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
    def levelOrder(self, root):
        """
        :type root: TreeNode
        :rtype: List[List[int]]
        """
        if not root:
            return []
        res = []
        q = Queue.Queue()
        q.put(root)
        while not q.empty():
            size = q.qsize
            vec = []
            while size > 0:
                size -= 1
                cur = q.get()
                if cur.left:
                    q.put(cur.left)
                if cur.right:
                    q.put(cur.right)
                vec.append(cur.val)
            res.append(vec)
        return res
