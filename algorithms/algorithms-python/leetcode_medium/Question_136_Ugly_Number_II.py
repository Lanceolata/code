#!/usr/bin/python
# coding: utf-8

class Solution(object):
    def nthUglyNumber(self, n):
        """
        :type n: int
        :rtype: int
        """
        res = [1]
        i2, i3, i5 = 0, 0, 0
        while len(res) < n:
            m2, m3, m5 = res[i2] * 2, res[i3] * 3, res[i5] * 5,
            mn = min(m2, m3, m5)
            if mn == m2:
                i2 += 1
            if mn == m3:
                i3 += 1
            if mn == m5:
                i5 += 1
            res.append(mn)
        return res[-1]

sol = Solution()
print sol.nthUglyNumber(10)