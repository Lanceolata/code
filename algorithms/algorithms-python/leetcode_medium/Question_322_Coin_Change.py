#!/usr/bin/python
# coding: utf-8

class Solution(object):
    def coinChange(self, coins, amount):
        """
        :type coins: List[int]
        :type amount: int
        :rtype: int
        """
        if amount == 0 or not coins:
            return 0
        dp = [amount + 1] * (amount + 1)
        dp[0] = 0
        for i in coins:
            for j in range(1, amount + 1):
                if j >= i:
                    dp[j] = min(dp[j], dp[j - i] + 1)
        if dp[amount] > amount:
            return -1
        else:
            return dp[amount]