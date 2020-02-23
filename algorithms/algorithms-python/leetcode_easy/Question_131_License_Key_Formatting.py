#!/usr/bin/python
# coding: utf-8

class Solution(object):
    def licenseKeyFormatting(self, S, K):
        """
        :type S: str
        :type K: int
        :rtype: str
        """
        res = []
        s = S.upper();
        cnt = 0
        for i in s[::-1]:
            if i == "-":
                continue
            cnt += 1
            res.append(i)
            if cnt % K == 0:
                res.append("-")
        if res and res[-1] == "-":
            res.pop()
        return "".join(res[::-1])
