#!/usr/bin/python
# coding: utf-8

class Solution(object):
    def combinationSum3(self, k, n):
        """
        :type k: int
        :type n: int
        :rtype: List[List[int]]
        """
        vec = []
        res = []
        self.helper(k, n, 1, vec, res)
        return res

    def helper(self, k, n, l, vec, res):
        if n < 0:
            return
        if n == 0 and len(vec) == k:
            res.append(vec[:])
            return
        for i in range(l, 10):
            vec.append(i)
            self.helper(k, n - i, i + 1, vec, res)
            vec.pop()
