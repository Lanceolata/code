#!/usr/bin/python
# coding: utf-8

class Solution(object):
    def addStrings(self, num1, num2):
        """
        :type num1: str
        :type num2: str
        :rtype: str
        """
        carry = 0
        res = []
        i, j = len(num1) - 1, len(num2) - 1
        while i >= 0 or j >= 0 or carry != 0:
            sum = 0
            if i >= 0:
                sum += int(num1[i])
                i -= 1
            if j >= 0:
                sum += int(num2[j])
                j -= 1
            sum += carry
            carry = sum / 10
            sum = sum % 10
            res.append(str(sum))
        return "".join(res[::-1])
