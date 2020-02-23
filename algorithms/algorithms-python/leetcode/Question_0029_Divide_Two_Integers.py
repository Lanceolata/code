#!/usr/bin/python
# coding: utf-8

class Solution(object):
    def divide(self, dividend, divisor):
        """
        :type dividend: int
        :type divisor: int
        :rtype: int
        """
        m, n, res = abs(dividend), abs(divisor), 0
        while m >= n:
            t, p = n, 1
            while m > (t << 1):
                t <<= 1
                p <<= 1
            m -= t
            res += p
        if (dividend < 0) ^ (divisor < 0):
            res = -res
        if res > 2147483647:
            return 2147483647
        else:
            return res
