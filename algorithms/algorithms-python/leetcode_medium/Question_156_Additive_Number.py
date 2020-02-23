#!/usr/bin/python
# coding: utf-8

class Solution(object):
    def isAdditiveNumber(self, num):
        """
        :type num: str
        :rtype: bool
        """
        length = len(num)
        for i in range(1, length):
            for j in range(i + 1, length):
                s1, s2 = num[0 : i], num[i : j]
                if (len(s1) > 1 and s1[0] == '0') or (len(s2) > 1 and s2[0] == '0'):
                    continue
                d1, d2 = int(s1), int(s2)
                next = d1 + d2
                now = s1 + s2 + str(next)
                while len(now) < len(num):
                    d1 = d2
                    d2 = next
                    next = d1 + d2
                    now += str(next)
                if now == num:
                    return True
        return False
