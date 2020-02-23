#!/usr/bin/python
# coding: utf-8

class Solution(object):
    def countPrimes(self, n):
        """
        :type n: int
        :rtype: int
        """
        if n < 3:
            return 0
        notPrime = [False] * n
        count = 1
        for i in range(3, n, 2):
            if not notPrime[i]:
                count += 1
                for j in range(i * i, n):
                    notPrime[j] = True
        return count
