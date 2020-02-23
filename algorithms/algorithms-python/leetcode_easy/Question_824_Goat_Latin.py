#!/usr/bin/python
# coding: utf-8

class Solution(object):
    def toGoatLatin(self, S):
        """
        :type S: str
        :rtype: str
        """
        s = set(["a", "e", "i", "o", "u", "A", "E", "I", "O", "U"])
        l = S.split()
        res = []
        count = 1
        for w in l:
            if w[0] in s:
                tmp = w
            else:
                tmp = w[1:] + w[0]
            tmp = tmp + "ma" + "a" * count
            count += 1
            res.append(tmp)
        return " ".join(res)
            
                
