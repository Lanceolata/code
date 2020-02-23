#!/usr/bin/python
# coding: utf-8

class Solution(object):
    def findNthDigit(self, n):
        """
        :type n: int
        :rtype: int
        """
        size, first, count = 1, 1, 9
        while n - size * count > 0:
            n -= size * count
            size, first, count = size + 1, first * 10, count * 10
        return int(str(first + (n - 1) // size)[(n - 1) % size])
