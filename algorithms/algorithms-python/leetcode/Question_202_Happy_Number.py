#!/usr/bin/python
# coding: utf-8

class Solution(object):
    def isHappy(self, n):
        """
        :type n: int
        :rtype: bool
        """
        slow , fast = n, n
        while True:
            slow = self.digitSquareSum(slow)
            fast = self.digitSquareSum(fast)
            fast = self.digitSquareSum(fast)
            if slow == fast:
                break
        return True if slow == 1 else False
        

    def digitSquareSum(self, n):
        sum, tmp = 0, 0
        while n:
            tmp = n % 10
            sum += tmp * tmp
            n /= 10
        return sum
