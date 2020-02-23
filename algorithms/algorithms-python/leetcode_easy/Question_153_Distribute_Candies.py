#!/usr/bin/python
# coding: utf-8

class Solution(object):
    def distributeCandies(self, candies):
        """
        :type candies: List[int]
        :rtype: int
        """
        s = set(candies)
        return min(len(s), len(candies) / 2)