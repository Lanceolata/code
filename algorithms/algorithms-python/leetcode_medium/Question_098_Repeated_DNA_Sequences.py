#!/usr/bin/python
# coding: utf-8

class Solution(object):
    def findRepeatedDnaSequences(self, s):
        """
        :type s: str
        :rtype: List[str]
        """
        if len(s) < 10:
            return []
        res, st = set(), set()
        m = {
            "A":0,
            "C":1,
            "G":2,
            "T":3
        }
        cur = 0
        for i in range(9):
            cur = cur << 2 | m[s[i]]
            i += 1
        for i in range(9, len(s)):
            cur = ((cur & 0x3ffff) << 2) | (m[s[i]])
            if cur in st:
                res.add(s[i - 9: i + 1])
            else:
                st.add(cur)
            i += 1
        return list(res)
