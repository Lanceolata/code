#!/usr/bin/python
# coding: utf-8

class Solution(object):
    def canCompleteCircuit(self, gas, cost):
        """
        :type gas: List[int]
        :type cost: List[int]
        :rtype: int
        """
        if not gas or not cost or len(gas) != len(cost):
            return -1
        total, num, index = 0, 0, -1
        for i in range(len(gas)):
            total += gas[i] - cost[i]
            num += gas[i] - cost[i]
            if num < 0:
                num = 0
                index = i
        return index + 1 if total >= 0 else -1
