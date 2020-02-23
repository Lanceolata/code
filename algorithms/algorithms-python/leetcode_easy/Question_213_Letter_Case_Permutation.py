#!/usr/bin/python
# coding: utf-8

class Solution(object):
    def letterCasePermutation(self, S):
        """
        :type S: str
        :rtype: List[str]
        """
        res = []
        self.dfs(S, 0, "", res)
        return res

    def dfs(self, S, pos, s, res):
        if pos == len(S):
            res.append(s)
            return
        else:
            if S[pos].isalpha():
                letter = S[pos]
                self.dfs(S, pos + 1, s + letter.upper(), res)
                self.dfs(S, pos + 1, s + letter.lower(), res)
            else:
                self.dfs(S, pos + 1, s + S[pos], res)
