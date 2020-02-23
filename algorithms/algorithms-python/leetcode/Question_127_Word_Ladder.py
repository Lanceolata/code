#!/usr/bin/python
# coding: utf-8

class Solution(object):
    def ladderLength(self, beginWord, endWord, wordList):
        """
        :type beginWord: str
        :type endWord: str
        :type wordList: List[str]
        :rtype: int
        """
        begin, end, bank = set([beginWord]), set([endWord]), set(wordList)
        return self.helper(end, begin, bank, 1) if endWord in bank else 0

    def helper(self, begin, end, bank, level):
        if not begin:
            return 0
        level += 1
        newBegin = set()
        for word in begin:
            for i in range(len(word)):
                chars = list(word)
                for j in range(ord('a'), ord('z') + 1):
                    chars[i] = chr(j)
                    newWord = ''.join(chars)
                    if newWord in end:
                        return level
                    if newWord in bank:
                        newBegin.add(newWord)
                        bank.remove(newWord)
        
        return self.helper(end, newBegin, bank, level) if len(newBegin) > len(end) else self.helper(newBegin, end, bank, level)
