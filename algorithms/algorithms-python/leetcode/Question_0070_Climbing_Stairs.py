#!/usr/bin/python
# coding: utf-8

class Solution(object):
    def climbStairs(self, n):
        """
        :type n: int
        :rtype: int
        """
        first = second = 1
        for i in range(n):
            first, second = second, first + second
        return first
