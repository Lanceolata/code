#!/usr/bin/python
# coding: utf-8

# Definition for an interval.
class Interval(object):
    def __init__(self, s=0, e=0):
        self.start = s
        self.end = e


class Solution(object):
    def insert(self, intervals, newInterval):
        """
        :type intervals: List[Interval]
        :type newInterval: Interval
        :rtype: List[Interval]
        """
        res = []
        inserted = False
        start, end = newInterval.start, newInterval.end
        for interval in intervals:
            if inserted or interval.end < start:
                res.append(interval)
            elif interval.start > end:
                res.append(Interval(start, end))
                inserted = True
                res.append(interval)
            else:
                start = min(start, interval.start)
                end = max(end, interval.end)
        if not inserted:
            res.append(Interval(start, end))
        return res