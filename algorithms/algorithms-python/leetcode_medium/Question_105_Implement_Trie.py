#!/usr/bin/python
# coding: utf-8

class TrieNode(object):
    def __init__(self):
        self.isWord = False
        self.child = [None] * 26

class Trie(object):
    ord_a = ord('a')
    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.root = TrieNode()
        

    def insert(self, word):
        """
        Inserts a word into the trie.
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
        Returns if the word is in the trie.
        :type word: str
        :rtype: bool
        """
        p = self.root
        for c in word:
            i = ord(c) - self.ord_a
            if not p.child[i]:
                return False
            p = p.child[i]
        return p.isWord
        

    def startsWith(self, prefix):
        """
        Returns if there is any word in the trie that starts with the given prefix.
        :type prefix: str
        :rtype: bool
        """
        p = self.root
        for c in prefix:
            i = ord(c) - self.ord_a
            if not p.child[i]:
                return False
            p = p.child[i]
        return True