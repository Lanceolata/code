#!/usr/bin/python
# coding: utf-8

class Solution(object):
    def numJewelsInStones(self, J, S):
        """
        :type J: str
        :type S: str
        :rtype: int
        """
        count = {}
        for c in S:
            if c not in count:
                count[c] = 0
            count[c] += 1
        res = 0
        for c in J:
            if c in count:
                res += count[c]
        return res