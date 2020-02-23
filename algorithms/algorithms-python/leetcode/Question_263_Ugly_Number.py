#!/usr/bin/python
# coding: utf-8

class Solution(object):
    def isUgly(self, num):
        """
        :type num: int
        :rtype: bool
        """
        if num == 0:
            return False
        for i in 2, 3, 5:
            while num % i == 0:
                num /= i
        return num == 1


sol = Solution()
print sol.isUgly(6)
print sol.isUgly(8)
print sol.isUgly(14)
