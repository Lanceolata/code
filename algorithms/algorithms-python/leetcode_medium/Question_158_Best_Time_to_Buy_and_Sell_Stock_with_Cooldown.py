#!/usr/bin/python
# coding: utf-8

class Solution(object):
    def maxProfit(self, prices):
        """
        :type prices: List[int]
        :rtype: int
        """
        buy, pre_buy, sell, pre_sell = -sys.maxsize -1, 0, 0, 0
        for p in prices:
            pre_buy = buy
            buy = max(pre_sell - p, pre_buy)
            pre_sell = sell
            sell = max(pre_buy + p, pre_sell)
        return sell