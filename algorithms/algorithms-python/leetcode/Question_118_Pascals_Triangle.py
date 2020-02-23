#!/usr/bin/python
# coding: utf-8

class Solution(object):
    def generate(self, numRows):
        """
        :type numRows: int
        :rtype: List[List[int]]
        """
        if numRows <= 0:
            return []
        res = []
        for i in range(numRows):
            res.append([1 if j == 0 or j == i else res[i - 1][j - 1] + res[i - 1][j] for j in range(i + 1)])
        return res
