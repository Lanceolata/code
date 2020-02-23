#!/usr/bin/python
# coding: utf-8

import sys

class Solution(object):
    def maxProfit(self, prices):
        """
        :type prices: List[int]
        :rtype: int
        """
        minprice = sys.maxint
        maxprofit = 0
        for i in prices:
            if i < minprice:
                minprice = i
            elif i - minprice > maxprofit:
                maxprofit = i - minprice
        return maxprofit
