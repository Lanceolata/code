#!/usr/bin/python
# coding: utf-8

class Solution(object):
    def findAnagrams(self, s, p):
        """
        :type s: str
        :type p: str
        :rtype: List[int]
        """
        res = []
        sv, pv = [0] * 256, [0] * 256
        if len(s) < len(p):
            return res
        for i in range(len(p)):
            sv[ord(s[i])] += 1
            pv[ord(p[i])] += 1

        if sv == pv:
            res.append(0)

        plen = len(p)
        for i in range(plen, len(s)):
            sv[ord(s[i])] += 1
            sv[ord(s[i - plen])] -= 1
            if sv == pv:
                res.append(i - plen + 1)
        return res
