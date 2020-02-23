#!/usr/bin/python
# coding: utf-8

class Solution(object):
    def multiply(self, num1, num2):
        """
        :type num1: str
        :type num2: str
        :rtype: str
        """
        zero = ord('0')
        res = [0] * (len(num1) + len(num2))
        for i in range(len(num1) - 1, -1, -1):
            for j in range(len(num2) - 1, -1, -1):
                res[i + j + 1] += (ord(num1[i]) - zero) * (ord(num2[j]) - zero)
                res[i + j] += res[i + j + 1] / 10
                res[i + j + 1] = res[i + j + 1] % 10
        
        s = []
        for i in res:
            if not s and i == 0:
                continue
            s.append(str(i))
        
        if len(s) == 0:
            return "0"
        else:
            return "".join(s)
