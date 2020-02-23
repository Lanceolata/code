#!/usr/bin/python
# coding: utf-8

class Solution(object):
    def longestWord(self, words):
        wordset = set()
        words.sort()
        res = ""
        for word in words:
            if len(word) == 1 or (word[0:-1] in wordset):
                if len(word) > len(res):
                    res = word
                wordset.add(word)
        return res

words = ["w","wo","wor","worl","world"]
sol = Solution()
print sol.longestWord(words)