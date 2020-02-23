#!/usr/bin/python
# coding: utf-8

import collections

# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution(object):
    def zigzagLevelOrder(self, root):
        """
        :type root: TreeNode
        :rtype: List[List[int]]
        """
        if not root:
            return []
        res = []
        dq = collections.deque()
        dq.append(root)
        flag = True
        while len(dq) > 0:
            vec = []
            size = len(dq)
            while size > 0:
                size -= 1
                if flag:
                    cur = dq.popleft()
                    if cur.left:
                        dq.append(cur.left)
                    if cur.right:
                        dq.append(cur.right)
                    vec.append(cur.val)
                else:
                    cur = dq.pop()
                    if cur.right:
                        dq.appendleft(cur.right)
                    if cur.left:
                        dq.appendleft(cur.left)
                    vec.append(cur.val)
            flag = not flag
            res.append(vec)
        return res
                