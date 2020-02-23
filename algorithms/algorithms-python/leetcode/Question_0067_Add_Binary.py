#!/usr/bin/python
# coding: utf-8

class Solution(object):
    def addBinary(self, a, b):
        """
        :type a: str
        :type b: str
        :rtype: str
        """
        if not a:
            return b
        if not b:
            return a
        carry, i, j = 0, len(a) - 1, len(b) - 1
        res = []
        while i >= 0 or j >= 0 or carry == 1:
            if i >= 0:
                carry += int(a[i])
                i -= 1
            if j >= 0:
                carry += int(b[j])
                j -= 1
            res.append(carry % 2)
            carry /= 2
        return "".join([str(i) for i in res[::-1]])
