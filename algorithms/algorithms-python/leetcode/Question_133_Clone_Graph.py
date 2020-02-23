#!/usr/bin/python
# coding: utf-8


# Definition for a Node.
class Node(object):
    def __init__(self, val, neighbors):
        self.val = val
        self.neighbors = neighbors


class Solution(object):
    def cloneGraph(self, node):
        """
        :type node: Node
        :rtype: Node
        """
        map = {}
        return self.help(node, map)

    def help(self, node, map):
        if not node:
            return node
        if node.val in map:
            return map[node.val]
        newNode = Node(node.val, [])
        map[node.val] = newNode
        for i in node.neighbors:
            newNode.neighbors.append(self.help(i, map))
        return newNode
