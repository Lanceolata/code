#!/usr/bin/python
# coding: utf-8

import Queue

# Definition for a Node.
class Node(object):
    def __init__(self, val, children):
        self.val = val
        self.children = children

class Solution(object):
    def levelOrder(self, root):
        """
        :type root: Node
        :rtype: List[List[int]]
        """
        res = []
        if not root:
            return res
        q = Queue.Queue()
        q.put(root)
        while not q.empty():
            l = q.qsize()
            vec = []
            while l > 0:
                l -= 1
                n = q.get()
                vec.append(n.val)
                for i in n.children:
                    q.put(i)
            res.append(vec)
        return res

        


