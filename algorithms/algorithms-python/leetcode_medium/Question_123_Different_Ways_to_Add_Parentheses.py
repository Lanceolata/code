#!/usr/bin/python
# coding: utf-8

class Solution(object):
    def diffWaysToCompute(self, input):
        """
        :type input: str
        :rtype: List[int]
        """
        res = []
        for i in range(len(input)):
            c = input[i]
            if c == "+" or c == "-" or c == "*":
                left = self.diffWaysToCompute(input[0 : i])
                right = self.diffWaysToCompute(input[i + 1:])
                for l in left:
                    for r in right:
                        if c == "+":
                            res.append(l + r)
                        elif c == "-":
                            res.append(l - r)
                        else:
                            res.append(l * r)
        if not res:
            res.append(int(input))
        return res

    def diffWaysToCompute_cache(self, input):
        def dfs(s, cache) :
            ops = {'+':lambda x,y:x+y, '-':lambda x,y:x-y, '*':lambda x,y:x*y}
            if not cache.has_key(s) :
                ret = []
                for k, v in enumerate(s) :
                    if v in '+-*' :
                        for left in dfs(s[:k], cache) :
                            for right in dfs(s[k+1:], cache) :
                                ret.append(ops[v](left,right))
                if not ret :
                    ret.append(int(s))
                cache[s] = ret
            return cache[s]
        return dfs(input, {})
