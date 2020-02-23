#!/usr/bin/python
# coding: utf-8

class Solution(object):
    def shortestToChar(self, S, C):
        """
        :type S: str
        :type C: str
        :rtype: List[int]
        """
        n, pos = len(S), -len(S)
        res = [n] * n
        for i in range(n):
            if S[i] == C:
                pos = i
            res[i] = min(res[i], abs(i - pos))
        for i in range(n-1, -1, -1):
            if S[i] == C:
                pos = i
            res[i] = min(res[i], abs(i - pos));
        return res