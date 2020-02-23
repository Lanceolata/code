#!/usr/bin/python
# coding: utf-8

class Solution(object):
    def majorityElement(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        res = []
        m, n, cm, cn = 0, 0, 0, 0
        for i in nums:
            if i == m:
                cm += 1
            elif i == n:
                cn += 1
            elif cm == 0:
                m = i
                cm = 1
            elif cn == 0:
                n = i
                cn = 1
            else:
                cm -= 1
                cn -= 1
        cm, cn = 0, 0
        for i in nums:
            if i == m:
                cm += 1
            elif i == n:
                cn += 1
        if cm > int(float(len(nums)) / 3):
            res.append(m)
        if cn > int(float(len(nums)) / 3):
            res.append(n)
        return res