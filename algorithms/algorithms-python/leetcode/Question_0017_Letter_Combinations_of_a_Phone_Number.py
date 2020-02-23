#!/usr/bin/python
# coding: utf-8

class Solution(object):
    def letterCombinations(self, digits):
        """
        :type digits: str
        :rtype: List[str]
        """
        if not digits:
            return []
        res = []
        pre = []
        dic = ["abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"]
        self.dfs(digits, dic, 0, pre, res)
        return res

    def dfs(self, digits, dic, level, pre, res):
        if level == len(digits):
            res.append("".join(pre))
        else:
            s = dic[int(digits[level]) - 2]
            for c in s:
                pre.append(c)
                self.dfs(digits, dic, level + 1, pre, res)
                pre.pop()
