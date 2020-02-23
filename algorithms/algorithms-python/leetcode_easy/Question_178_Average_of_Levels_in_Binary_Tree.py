#!/usr/bin/python
# coding: utf-8

from TreeNode import *
import Queue

class Solution(object):
    def averageOfLevels(self, root):
        """
        :type root: TreeNode
        :rtype: List[float]
        """
        q = Queue.Queue()
        res = []
        q.put(root)
        while not q.empty():
            size = q.qsize()
            num = 0.0
            count = size
            while size != 0:
                size -= 1
                node = q.get()
                num += node.val
                if node.left:
                    q.put(node.left)
                if node.right:
                    q.put(node.right)
            res.append(num / count)
        return res
