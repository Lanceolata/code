#!/usr/bin/python
# coding: utf-8

class Solution(object):
    def wordBreak(self, s, wordDict):
        """
        :type s: str
        :type wordDict: List[str]
        :rtype: List[str]
        """
        m = {}
        return self.dfs(s, wordDict, m)

    def dfs(self, s, wordDict, m):
        if s in m:
            return m[s]

        if not s:
            return [""]

        res = []
        for word in wordDict:
            if s.startswith(word):
                sub = self.dfs(s[len(word):], wordDict, m)
                for w in sub:
                    if not w:
                        res.append(word)
                    else:
                         res.append("%s %s" % (word, w))
        m[s] = res
        return res
