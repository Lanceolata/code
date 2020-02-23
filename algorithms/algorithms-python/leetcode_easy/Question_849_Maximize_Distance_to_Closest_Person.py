#!/usr/bin/python
# coding: utf-8

class Solution(object):
    def maxDistToClosest(self, seats):
        """
        :type seats: List[int]
        :rtype: int
        """
        res, d = -1, 0
        for s in seats:
            if s == 1:
                if res == -1:
                    res = d
                else:
                    res = max(res, d / 2)
                d = 1
            else:
                d += 1
        return max(res, d - 1)