#!/usr/bin/python
# coding: utf-8

class Solution(object):
    def myAtoi(self, str):
        """
        :type str: str
        :rtype: int
        """
        if not str:
            return 0
        INT_MAX = 2147483647
        INT_MIN = -2147483648
        i, sign, n, res = 0, 1, len(str), 0
        while i < n and str[i] == ' ':
            i += 1
        if i < n and (str[i] == '+' or str[i] == '-'):
            sign = 1 if str[i] == '+' else -1
            i += 1
        while i < n and ord(str[i]) >= ord('0') and ord(str[i]) <= ord('9'):
            if res > INT_MAX // 10 or (res == INT_MAX // 10 and ord(str[i]) > ord('7')):
                return INT_MAX if sign == 1 else INT_MIN
            res = res * 10 + (ord(str[i]) - ord('0'))
            i +=1
        return sign * res
