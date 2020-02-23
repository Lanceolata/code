#!/usr/bin/python
# coding: utf-8

class Solution(object):
    def largeGroupPositions(self, S):
        """
        :type S: str
        :rtype: List[List[int]]
        """
        res = []
        start, n = 0, len(S)
        for i in range(n):
            if S[i] != S[start]:
                if i - start >= 3:
                    res.append([start, i - 1])
                start = i
        if S[i] == S[start] and i - start >= 2:
            res.append([start, i])
        return res