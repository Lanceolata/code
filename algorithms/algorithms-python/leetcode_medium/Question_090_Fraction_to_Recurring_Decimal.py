#!/usr/bin/python
# coding: utf-8

class Solution(object):
    def fractionToDecimal(self, numerator, denominator):
        """
        :type numerator: int
        :type denominator: int
        :rtype: str
        """
        if numerator == 0:
            return '0'
        neg = False
        if numerator > 0 and denominator < 0 or numerator < 0 and denominator > 0:
            neg = True

        if numerator % denominator == 0:
            return str(numerator / denominator)

        numerator = abs(numerator)
        denominator = abs(denominator)
        
        table = {}
        res = ""
        res += str(numerator / denominator)
        res += '.'
        numerator %= denominator
        i = len(res)
        while numerator:
            if numerator not in table:
                table[numerator] = i
            else:
                i = table[numerator]
                res = res[:i] + '(' + res[i:] + ')'
                if neg:
                    return '-' + res
                else:
                    return res
            numerator = numerator * 10
            res += str(numerator/denominator)
            numerator %= denominator
            i+=1
        if neg:
            return '-' + res
        return res