#!/usr/bin/python
# coding: utf-8

class Solution(object):
    def mostCommonWord(self, paragraph, banned):
        """
        :type paragraph: str
        :type banned: List[str]
        :rtype: str
        """
        li = re.split(r'[^a-zA-Z]{1,2}', paragraph)
        x = []
        for i in range(len(li)):
            if li[i] != "":
                x.append(li[i].lower())
        li_set = list(set(x))
        n = 0
        word = ""
        for i in li_set:
            if i not in banned:
                if x.count(i) > n:
                    n = x.count(i)
                    word = i
        return word
