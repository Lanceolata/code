#!/usr/bin/python
# coding: utf-8

class Solution(object):
    def combinationSum(self, candidates, target):
        """
        :type candidates: List[int]
        :type target: int
        :rtype: List[List[int]]
        """
        res, vec = [], []
        candidates.sort()
        self.help(candidates, target, 0, vec, res)
        return res

    def help(self, candidates, target, index, vec, res):
        if target == 0:
            res.append(vec[:])
            return
        
        for i in range(index, len(candidates)):
            if candidates[i] > target:
                return
            vec.append(candidates[i])
            self.help(candidates, target - candidates[i], i, vec, res)
            vec.pop()
