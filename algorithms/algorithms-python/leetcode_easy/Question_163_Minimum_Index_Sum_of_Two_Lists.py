#!/usr/bin/python
# coding: utf-8

import sys

class Solution(object):
    def findRestaurant(self, list1, list2):
        """
        :type list1: List[str]
        :type list2: List[str]
        :rtype: List[str]
        """
        m = {}
        res = []
        for i, v in enumerate(list1):
            m[v] = i
        min_sum = sys.maxint
        s = 0
        for i, v in enumerate(list2):
            if v in m:
                s = i + m[v]
                if s < min_sum:
                    del res[:]
                    res.append(v)
                    min_sum = s
                elif s == min_sum:
                    res.append(v)
        return res