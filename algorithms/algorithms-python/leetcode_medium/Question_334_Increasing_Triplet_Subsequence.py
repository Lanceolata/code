#!/usr/bin/python
# coding: utf-8

import sys

class Solution(object):
    def increasingTriplet(self, nums):
        """
        :type nums: List[int]
        :rtype: bool
        """
        m1, m2 = sys.maxint, sys.maxint
        for n in nums:
            if m1 >= n:
                m1 = n
            elif m2 >= n:
                m2 = n
            else:
                return True
        return False
