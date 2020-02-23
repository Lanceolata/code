#!/usr/bin/python
# coding: utf-8

class Solution(object):
    def numDecodings(self, s):
        """
        :type s: str
        :rtype: int
        """
        if not s or s[0] == '0':
            return 0
        num, num1, num2 = 1, 1, 1,
        for i in range(1, len(s)):
            if s[i] == '0':
                if s[i-1] == '1' or s[i-1] == '2':
                    num = num1
                else:
                    return 0
            else:
                if s[i-1] == '0' or int(s[i-1]) >= 3:
                    num = num2
                else:
                    if s[i-1] == '2' and int(s[i]) >=7 and int(s[i]) <= 9:
                        num = num2
                    else:
                        num = num1 + num2
            num1 = num2
            num2 = num
        return num2
