#!/usr/bin/python
# coding: utf-8

import sys

class Solution(object):
    def nthSuperUglyNumber(self, n, primes):
        """
        :type n: int
        :type primes: List[int]
        :rtype: int
        """
        m = len(primes)
        dp, idx = [1] * n, [0] * m
        for i in range(1, n):
            dp[i] = sys.maxint
            for j in range(m):
                dp[i] = min(dp[i], dp[idx[j]] * primes[j])
            for j in range(m):
                if dp[i] == dp[idx[j]] * primes[j]:
                    idx[j] += 1
        return dp[-1]
