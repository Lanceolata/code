#!/usr/bin/python
# coding: utf-8

class Solution(object):
    def findMinHeightTrees(self, n, edges):
        """
        :type n: int
        :type edges: List[List[int]]
        :rtype: List[int]
        """
        if n == 1:
            return [0]
        neighbor = [set() for i in range(n)]
        for p,q in edges:
            neighbor[p].add(q)
            neighbor[q].add(p)
        
        leaves = [x for x in range(n) if len(neighbor[x]) == 1]

        while n > 2:
            n -= len(leaves)
            newLeaves = []
            for p in leaves:
                q = neighbor[p].pop()
                neighbor[q].remove(p)
                if len(neighbor[q]) == 1:
                    newLeaves.append(q)
            leaves = newLeaves
        return leaves