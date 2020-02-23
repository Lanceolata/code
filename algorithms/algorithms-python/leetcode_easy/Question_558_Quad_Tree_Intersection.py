#!/usr/bin/python
# coding: utf-8

class Node(object):
    def __init__(self, val, isLeaf, topLeft, topRight, bottomLeft, bottomRight):
        self.val = val
        self.isLeaf = isLeaf
        self.topLeft = topLeft
        self.topRight = topRight
        self.bottomLeft = bottomLeft
        self.bottomRight = bottomRight


class Solution(object):
    def intersect(self, quadTree1, quadTree2):
        """
        :type quadTree1: Node
        :type quadTree2: Node
        :rtype: Node
        """
        if quadTree1.isLeaf and quadTree1.val:
            return quadTree1
        if quadTree2.isLeaf and quadTree2.val:
            return quadTree2
        if quadTree1.isLeaf and not quadTree1.val:
            return quadTree2
        if quadTree2.isLeaf and not quadTree2.val:
            return quadTree1
        
        tl = self.intersect(quadTree1.topLeft, quadTree2.topLeft)
        tr = self.intersect(quadTree1.topRight, quadTree2.topRight)
        bl = self.intersect(quadTree1.bottomLeft, quadTree2.bottomLeft)
        br = self.intersect(quadTree1.bottomRight, quadTree2.bottomRight)

        if tl.isLeaf and tr.isLeaf and bl.isLeaf and tr.isLeaf and tl.val == tr.val and tl.val == bl.val and tl.val == br.val:
            return Node(tl.val, True, None, None, None, None)
        else:
            return Node(False, False, tl, tr, bl, br)