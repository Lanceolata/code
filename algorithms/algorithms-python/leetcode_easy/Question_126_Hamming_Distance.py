#!/usr/bin/python
# coding: utf-8

class Solution(object):
    def hammingDistance(self, x, y):
        """
        :type x: int
        :type y: int
        :rtype: int
        """
        return self.countOne(x | y) - self.countOne(x & y)

    def countOne(self, n):
        num = 0
        while n != 0:
            n = n & (n - 1)
            num += 1
        return num

    def hammingDistance_fast(self, x, y):
        n = x ^ y
        num = 0
        while n != 0:
            n = n & (n - 1)
            num += 1
        return num
