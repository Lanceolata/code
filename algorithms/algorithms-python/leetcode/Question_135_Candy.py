#!/usr/bin/python
# coding: utf-8

class Solution(object):
    def candy(self, ratings):
        """
        :type ratings: List[int]
        :rtype: int
        """
        n = len(ratings)
        vec = [1] * n
        for i in range(1, n):
            if ratings[i] > ratings[i - 1]:
                vec[i] = vec[i - 1] + 1
        res = vec[n - 1]
        for i in range(n - 2, -1, -1):
            if ratings[i] > ratings[i + 1]:
                vec[i] = max(vec[i], vec[i + 1] + 1)
            res += vec[i]
        return res
