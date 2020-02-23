#!/usr/bin/python
# coding: utf-8

import math

class Solution(object):
    def judgeSquareSum(self, c):
        """
        :type c: int
        :rtype: bool
        """
        low = 0
        high = int(math.sqrt(c))
        while low <= high:
            num = low * low + high * high
            if num == c:
                return True
            elif num < c:
                low += 1
            else:
                high -= 1
        return False