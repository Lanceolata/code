#!/usr/bin/python
# coding: utf-8

class Interval(object):
    def __init__(self, s=0, e=0):
        self.start = s
        self.end = e


class Solution(object):
    def merge(self, intervals):
        """
        :type intervals: List[Interval]
        :rtype: List[Interval]
        """
        n = len(intervals)
        starts, ends = [], []
        for i in intervals:
            starts.append(i.start)
            ends.append(i.end)
        starts.sort()
        ends.sort()

        j = 0
        res = []
        for i in range(n):
            if i == n - 1 or starts[i + 1] > ends[i]:
                res.append(Interval(starts[j], ends[i]))
                j = i + 1
        return res
