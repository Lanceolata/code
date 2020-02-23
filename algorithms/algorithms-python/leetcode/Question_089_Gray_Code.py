#!/usr/bin/python
# coding: utf-8

class Solution(object):
    def grayCode(self, n):
        """
        :type n: int
        :rtype: List[int]
        """
        if n == 0:
            return [0]
        res = []
        for i in range(2 ** n):
            res.append(i ^ (i >> 1))
        return res
