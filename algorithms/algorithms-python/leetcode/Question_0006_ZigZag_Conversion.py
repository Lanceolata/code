#!/usr/bin/python
# coding: utf-8

class Solution(object):
    def convert(self, s, numRows):
        """
        :type s: str
        :type numRows: int
        :rtype: str
        """
        if numRows < 2:
            return s
        res = []
        lag = 2 * (numRows - 1)
        num = len(s)
        for i in range(numRows):
            for j in range(i, num, lag):
                res.append(s[j])
                if i > 0 and i < numRows - 1:
                    n = j + lag - 2 * i
                    if n < num:
                        res.append(s[n])
        return "".join(res)
