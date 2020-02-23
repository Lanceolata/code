#!/usr/bin/python
# coding: utf-8

class Solution(object):
    def transpose(self, A):
        """
        :type A: List[List[int]]
        :rtype: List[List[int]]
        """
        m, n = len(A), len(A[0])
        res = [[0] * m for i in range(n)]
        for i in range(m):
            for j in range(n):
                res[j][i] = A[i][j]
        return res
