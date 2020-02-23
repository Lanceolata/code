#!/usr/bin/python
# coding: utf-8

class Solution(object):
    def intToRoman(self, num):
        """
        :type num: int
        :rtype: str
        """
        symbol = ["M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"]
        value = [1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1]
        res = []
        i = 0
        while num != 0:
            while num >= value[i]:
                num -= value[i]
                res.append(symbol[i])
            i += 1
        return "".join(res)
