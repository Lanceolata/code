#!/usr/bin/python
# coding: utf-8

import math

class Solution(object):
    def numSquares(self, n):
        """
        :type n: int
        :rtype: int
        """
        while n % 4 == 0:
            n /= 4
        if n % 8 == 7:
            return 4
        for a in range(int(math.floor(math.sqrt(n))) + 1):
            b = int(math.floor(math.sqrt(n - a * a)))
            if a * a + b * b == n:
                if a <= 0 or b <= 0:
                    return 1
                else:
                    return 2
        return 3
