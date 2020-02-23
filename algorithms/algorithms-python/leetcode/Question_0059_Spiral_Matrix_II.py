#!/usr/bin/python
# coding: utf-8

class Solution(object):
    def generateMatrix(self, n):
        """
        :type n: int
        :rtype: List[List[int]]
        """
        if n <= 0:
            return None
        res = [[0] * n for i in range(n)]
        r1, r2, c1, c2, v = 0, n - 1, 0, n - 1, 1
        while r1 <= r2 and c1 <= c2:
            for i in range(c1, c2 + 1):
                res[r1][i] = v
                v += 1
            for i in range(r1 + 1, r2 + 1):
                res[i][c2] = v
                v += 1
            for i in range(c2 - 1, c1 - 1, -1):
                res[r2][i] = v
                v += 1
            for i in range(r2 - 1, r1, -1):
                res[i][c1] = v
                v += 1
            r1, r2, c1, c2 = r1 + 1, r2 - 1, c1 + 1, c2 - 1
        return res
