#!/usr/bin/python
# coding: utf-8

class Solution(object):
    def maxProduct(self, words):
        """
        :type words: List[str]
        :rtype: int
        """
        res, m = 0, {}
        for s in words:
            mask = 0
            for c in s:
                mask |= 1 << (ord(c) - ord("a"))
            if mask not in m:
                m[mask] = 0
            m[mask] = max(m[mask], len(s))
            for k, v in m.items():
                if (mask & k) == 0:
                    res = max(res, v * len(s))
        return res