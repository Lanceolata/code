#!/usr/bin/python
# coding: utf-8

class Solution(object):
    def uniquePaths(self, m, n):
        """
        :type m: int
        :type n: int
        :rtype: int
        """
        dp = [0] * n
        dp[0] = 1
        for i in range(m):
            for j in range(1, n):
                dp[j] += dp[j - 1]
        return dp[n - 1]
