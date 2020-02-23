#!/usr/bin/python
# coding: utf-8

class Solution(object):
    def isPalindrome(self, x):
        """
        :type x: int
        :rtype: bool
        """
        if x < 0:
            return False
        help = 1
        while x / help >= 10:
            help *= 10
        while x != 0:
            if x / help != x % 10:
                return False
            x = (x % help) / 10
            help /= 100
        return True
