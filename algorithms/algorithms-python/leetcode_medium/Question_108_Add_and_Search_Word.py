#!/usr/bin/python
# coding: utf-8

class TrieNode(object):
    def __init__(self):
        self.isWord = False
        self.child = [None] * 26

class WordDictionary(object):
    ord_a = ord('a')
    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.root = TrieNode()
        

    def addWord(self, word):
        """
        Adds a word into the data structure.
        :type word: str
        :rtype: void
        """
        p = self.root
        for c in word:
            i = ord(c) - self.ord_a
            if not p.child[i]:
                p.child[i] = TrieNode()
            p = p.child[i]
        p.isWord = True

    def search(self, word):
        """
        Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter.
        :type word: str
        :rtype: bool
        """
        return self.searchWord(self.root, word, 0)
        

    def searchWord(self, p, word, i):
        """
        Returns if there is any word in the trie that starts with the given prefix.
        :type prefix: str
        :rtype: bool
        """
        if i == len(word):
            return p.isWord
        if word[i] == '.':
            for c in p.child:
                if c and self.searchWord(c, word, i + 1):
                    return True
            return False
        else:
            if p.child[ord(word[i]) - self.ord_a]:
                return self.searchWord(word, p.child[ord(word[i]) - self.ord_a], i + 1)
            else:
                return False

wd = WordDictionary()
wd.addWord("bad")
wd.addWord("dad")
wd.addWord("mad")
print wd.search("pad")