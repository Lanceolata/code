#!/usr/bin/python
# coding: utf-8

class Solution(object):
    def checkPerfectNumber(self, num):
        """
        :type num: int
        :rtype: bool
        """
        if num <= 0:
            return False

        count, i = 0, 1
        while i * i <= num:
            if num % i == 0:
                count += i
                if i * i != num:
                    count += num / i
            i += 1

        return count - num == num


