#!/usr/bin/python
# coding: utf-8

import Queue

class Solution(object):
    def findOrder(self, numCourses, prerequisites):
        """
        :type numCourses: int
        :type prerequisites: List[List[int]]
        :rtype: bool
        """
        graph = [[] for i in range(numCourses)]
        inDegree = [0] * numCourses
        for i in prerequisites:
            graph[i[1]].append(i[0])
            inDegree[i[0]] += 1
        q = Queue.Queue()
        for i, val in enumerate(inDegree):
            if val == 0:
                q.put(i)
        res = []
        while not q.empty():
            i = q.get()
            res.append(i)
            for j in graph[i]:
                inDegree[j] -= 1
                if inDegree[j] == 0:
                    q.put(j)
        for i in inDegree:
            if i != 0:
                return []
        return res
