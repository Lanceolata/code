#!/usr/bin/python
# coding: utf-8

class Solution(object):
    def calculate(self, s):
        """
        :type s: str
        :rtype: int
        """
        res, curRes, num, n = 0, 0, 0, len(s)
        op = '+'
        for i in range(n):
            c = s[i]
            if c.isdigit():
                num = num * 10 + int(c)
            if c == '+' or c == '-' or c == "*" or c == "/" or i == n - 1:
                if op == '+':
                    curRes += num
                elif op == '-':
                    curRes -= num
                elif op == "*": 
                    curRes *= num
                elif op == "/":
                    if curRes != 0:
                        curRes = int(float(curRes)/num)
            
                if c == '+' or c == '-' or i == n - 1:
                    res += curRes
                    curRes = 0
                op = c
                num = 0
        return res

sol = Solution()
print sol.calculate("3+2*2")
            