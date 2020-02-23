#!/usr/bin/python
# coding: utf-8

class Solution(object):
    def evalRPN(self, tokens):
        """
        :type tokens: List[str]
        :rtype: int
        """
        if len(tokens) == 1:
            return int(tokens[0])
        s = []
        ops = set(["+", "-", "*", "/"])
        for i in tokens:
            if i in ops:
                n = s.pop()
                m = s.pop()
                if i == "+":
                    s.append(m + n)
                if i == "-":
                    s.append(m - n)
                if i == "*":
                    s.append(n * m)
                if i == "/":
                    s.append(int(float(m)/n))
            else:
                s.append(int(i))
        return s[-1]
