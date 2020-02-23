#!/usr/bin/python
# coding: utf-8

import sys

class Solution(object):
    def maxProfit(self, prices):
        """
        :type prices: List[int]
        :rtype: int
        """
        buy1, sell1, buy2, sell2 = -sys.maxint - 1, 0, -sys.maxint - 1, 0
        for p in prices:
            sell2 = max(sell2, buy2 + p)
            buy2 = max(buy2, sell1 - p)
            sell1 = max(sell1, buy1 + p)
            buy1 = max(buy1, -p)
        return sell2
