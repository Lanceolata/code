#!/usr/bin/python
# coding: utf-8

class Solution(object):
    def binaryGap(self, N):
        """
        :type N: int
        :rtype: int
        """
        res, pre, cur = 0, -1, 0
        while N > 0:
            if (N & 1) == 1:
                if pre == -1:
                    pre = cur
                else:
                    res = max(cur - pre, res)
                    pre = cur
            cur += 1
            N >>= 1
        return res