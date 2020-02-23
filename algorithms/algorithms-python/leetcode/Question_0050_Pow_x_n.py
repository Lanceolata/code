#!/usr/bin/python
# coding: utf-8

class Solution(object):
    def myPow(self, x, n):
        """
        :type x: float
        :type n: int
        :rtype: float
        """
        if n < 0:
            return 1 / x * 1 / self.myPow(x, -(n + 1))
        elif n == 0:
            return 1.0
        elif n == 1:
            return float(x)

        half = self.myPow(x, n >> 1)
        half *= half

        if n & 1 == 1:
            half *= x
        return half
