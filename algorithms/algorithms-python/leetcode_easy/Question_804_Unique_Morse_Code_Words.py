#!/usr/bin/python
# coding: utf-8

class Solution(object):
    ch2morse = [
        ".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.",
        "---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."
    ]

    def uniqueMorseRepresentations(self, words):
        """
        :type words: List[str]
        :rtype: int
        """
        a, s = ord("a"), set()
        for w in words:
            t = "".join([self.ch2morse[ord(c) - a] for c in w])
            s.add(t)
        return len(s)
                