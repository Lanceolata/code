#!/usr/bin/python
# coding: utf-8

import sys

class Solution(object):
    def minCut(self, s):
        """
        :type s: str
        :rtype: int
        """
        n = len(s)
        dp = [sys.maxint] * (n + 1)
        dp[0] = -1
        for i in range(n):
            j = 0
            while i - j >= 0 and i + j < n and s[i - j] == s[i + j]:
                dp[i + j + 1] = min(dp[i + j + 1], 1 + dp[i - j])
                j += 1
            j = 1
            while i - j + 1 >= 0 and i + j < n and s[i - j + 1] == s[i + j]:
                dp[i + j + 1] = min(dp[i + j + 1], 1 + dp[i - j + 1])
                j += 1
        return dp[n]
